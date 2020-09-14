package com.github.yangweigbh.modern_android_template.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.yangweigbh.modern_android_template.weather.data.WeatherRepository
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val weatherRepository: WeatherRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(weatherRepository) as T
    }
}