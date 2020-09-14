package com.github.yangweigbh.modern_android_template.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData
import com.github.yangweigbh.modern_android_template.weather.data.WeatherRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val weatherRepository: WeatherRepository): ViewModel() {
    private val _weatherSummary: MutableLiveData<List<WeatherData>> = MutableLiveData()

    val weatherSummary : LiveData<List<WeatherData>>
        get() = _weatherSummary

    fun getData() {
        viewModelScope.launch {
            val list = weatherRepository.getWeatherSummary();
            _weatherSummary.postValue(list)
        }
    }
}