package com.github.yangweigbh.modern_android_template.weather.data

interface WeatherDataSource {
    suspend fun getWeatherSummary(): List<WeatherData>
    suspend fun getWeatherByCity(city: String): WeatherData
}
