package com.github.yangweigbh.modern_android_template.weather.api

import com.github.yangweigbh.modern_android_template.weather.data.ApiResponse
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class FakeWeatherService @Inject constructor(): WeatherService {
    override fun getSummary(): Flow<ApiResponse<List<WeatherData>>> = flow {
        val res = listOf<WeatherData>(
            WeatherData("Beijing", "Sunny", 30),
            WeatherData("Tianjin", "Rainy", 38))

        delay(10000)
        emit(ApiResponse.create(Response.success(res)))
    }.flowOn(Dispatchers.IO)
}