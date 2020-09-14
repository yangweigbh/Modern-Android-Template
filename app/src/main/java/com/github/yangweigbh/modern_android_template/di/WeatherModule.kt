package com.github.yangweigbh.modern_android_template.di

import com.github.yangweigbh.modern_android_template.weather.data.WeatherDataSource
import com.github.yangweigbh.modern_android_template.weather.data.WeatherDataSourceImpl
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
    abstract fun bindWeatherDataSource(impl: WeatherDataSourceImpl): WeatherDataSource
}