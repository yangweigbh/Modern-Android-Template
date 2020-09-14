package com.github.yangweigbh.modern_android_template.weather.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(private val weatherDataSource: WeatherDataSource) {
    suspend fun getWeatherSummary(): List<WeatherData> {
        return weatherDataSource.getWeatherSummary()
    }

    suspend fun getWeatherByCity(city: String): WeatherData {
        return weatherDataSource.getWeatherByCity(city)
    }

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: WeatherRepository? = null

        fun getInstance(weatherDataSource: WeatherDataSource) =
            instance ?: synchronized(this) {
                instance ?: WeatherRepository(weatherDataSource).also { instance = it }
            }
    }
}