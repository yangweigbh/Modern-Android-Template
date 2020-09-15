package com.github.yangweigbh.modern_android_template.di

import com.github.yangweigbh.modern_android_template.weather.api.FakeWeatherService
import com.github.yangweigbh.modern_android_template.weather.api.WeatherService
import com.github.yangweigbh.modern_android_template.weather.db.FakeWeatherDao
import com.github.yangweigbh.modern_android_template.weather.db.WeatherDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class WeatherModule {
    @Singleton
    @Binds
    abstract fun bindWeatherDao(impl: FakeWeatherDao): WeatherDao

    @Singleton
    @Binds
    abstract fun bindWeatherService(impl: FakeWeatherService): WeatherService
}