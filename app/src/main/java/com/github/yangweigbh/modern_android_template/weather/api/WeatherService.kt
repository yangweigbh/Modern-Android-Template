package com.github.yangweigbh.modern_android_template.weather.api

import com.github.yangweigbh.modern_android_template.weather.data.ApiResponse
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherService {
    fun getSummary(): Flow<ApiResponse<List<WeatherData>>>
}