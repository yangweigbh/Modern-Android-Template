/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.yangweigbh.modern_android_template.weather.data

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

/**
 * A generic class that can provide a resource backed by both the sqlite database and the network.
 *
 *
 * You can read more about it in the [Architecture
 * Guide](https://developer.android.com/arch).
 * @param <ResultType>
 * @param <RequestType>
</RequestType></ResultType> */
abstract class NetworkBoundResource<ResultType, RequestType> {

    val result: Flow<Resource<ResultType>> = flow {
        emit(Resource.loading(null))

        val dbSource = loadFromDb()

        dbSource.collect { value: ResultType? ->
            if (shouldFetch(value)) {
                emitAll(fetchFromNetwork(value))
            } else {
                emit(Resource.success(value))
            }
        }
    }

    private fun fetchFromNetwork(dbSource: ResultType?): Flow<Resource<ResultType>> = flow {
        val apiResponse = createCall()
        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
        emit(Resource.loading(dbSource))

        apiResponse.collect { response: ApiResponse<RequestType> ->
            when (response) {
                is ApiSuccessResponse -> {
                    saveCallResult(processResponse(response))

                    loadFromDb().collect { value: ResultType? ->
                        emit(Resource.success(value))
                    }
                }
                is ApiEmptyResponse -> {
                    loadFromDb().collect { value: ResultType? ->
                        emit(Resource.success(value))
                    }
                }
                is ApiErrorResponse -> {
                    onFetchFailed()

                    loadFromDb().collect { value: ResultType? ->
                        emit(Resource.error(response.errorMessage, value))
                    }
                }
            }
        }
    }

    protected open fun onFetchFailed() {}

    @WorkerThread
    protected open fun processResponse(response: ApiSuccessResponse<RequestType>) = response.body

    @WorkerThread
    protected abstract fun saveCallResult(item: RequestType)

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract fun loadFromDb(): Flow<ResultType?>

    @MainThread
    protected abstract fun createCall(): Flow<ApiResponse<RequestType>>
}
