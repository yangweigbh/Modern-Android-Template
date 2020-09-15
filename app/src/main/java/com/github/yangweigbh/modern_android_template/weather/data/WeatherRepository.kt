package com.github.yangweigbh.modern_android_template.weather.data

import com.github.yangweigbh.modern_android_template.weather.api.WeatherService
import com.github.yangweigbh.modern_android_template.weather.db.WeatherDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val weatherDao: WeatherDao,
    private val weatherService: WeatherService
) {
    fun getWeatherSummary(): Flow<Resource<List<WeatherData>>> {
        return object : NetworkBoundResource<List<WeatherData>, List<WeatherData>>() {
            override fun saveCallResult(items: List<WeatherData>) {
                weatherDao.saveWeatherSummary(items)
            }

            override fun shouldFetch(data: List<WeatherData>?): Boolean {
                return data == null
            }

            override fun loadFromDb(): Flow<List<WeatherData>?> {
                return weatherDao.getWeatherSummary()
            }

            override fun createCall(): Flow<ApiResponse<List<WeatherData>>> {
                return weatherService.getSummary()
            }
        }.result
    }

    suspend fun getWeatherByCity(city: String): WeatherData {
        return weatherDao.getWeatherByCity(city)
    }
}