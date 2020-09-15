package com.github.yangweigbh.modern_android_template.weather.db

import com.github.yangweigbh.modern_android_template.weather.data.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FakeWeatherDao @Inject constructor(): WeatherDao {
    private var cache: List<WeatherData>? = null

    override fun saveWeatherSummary(items: List<WeatherData>) {
        cache = items
    }

    override fun getWeatherSummary(): Flow<List<WeatherData>?> = flow {
        delay(2000)

        cache?.apply {
            emit(this)
        } ?: emit(null)
    }.flowOn(Dispatchers.IO)

    override suspend fun getWeatherByCity(city: String): WeatherData {
        TODO("Not yet implemented")
    }
}