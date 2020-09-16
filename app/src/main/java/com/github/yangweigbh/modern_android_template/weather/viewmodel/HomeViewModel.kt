package com.github.yangweigbh.modern_android_template.weather.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.github.yangweigbh.modern_android_template.weather.data.Resource
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData
import com.github.yangweigbh.modern_android_template.weather.data.WeatherRepository
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val weatherRepository: WeatherRepository): ViewModel() {
    private val _weatherSummary: MediatorLiveData<Resource<List<WeatherData>>> = MediatorLiveData()

    val weatherSummary : LiveData<Resource<List<WeatherData>>>
        get() = _weatherSummary

    fun getData() {
        viewModelScope.launch {
            val list = weatherRepository.getWeatherSummary();
            _weatherSummary.addSource(list.asLiveData(coroutineContext)) {
                _weatherSummary.value = it
            }
        }
    }
}