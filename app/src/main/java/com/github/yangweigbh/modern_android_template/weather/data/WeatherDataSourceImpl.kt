package com.github.yangweigbh.modern_android_template.weather.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherDataSourceImpl @Inject constructor(): WeatherDataSource {
    override suspend fun getWeatherSummary(): List<WeatherData> {
        return withContext(Dispatchers.IO) {
            delay(5000)

            val res = listOf<WeatherData>(WeatherData("Beijing", "Sunny", 30),
                WeatherData("Tianjing", "Rainy", 23)
            )

            return@withContext res
        }
    }

    override suspend fun getWeatherByCity(city: String): WeatherData {
        TODO("Not yet implemented")
    }

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: WeatherDataSourceImpl? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: WeatherDataSourceImpl().also { instance = it }
            }
    }
}