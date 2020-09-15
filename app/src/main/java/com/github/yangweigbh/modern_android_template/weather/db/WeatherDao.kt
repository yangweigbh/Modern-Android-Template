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

package com.github.yangweigbh.modern_android_template.weather.db

import androidx.lifecycle.LiveData
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData
import kotlinx.coroutines.flow.Flow

/**
 * Interface for database access for User related operations.
 */
interface WeatherDao {
    fun saveWeatherSummary(items: List<WeatherData>)
    fun getWeatherSummary(): Flow<List<WeatherData>?>
    suspend fun getWeatherByCity(city: String): WeatherData
}
