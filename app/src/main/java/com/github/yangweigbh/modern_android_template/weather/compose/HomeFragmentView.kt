package com.github.yangweigbh.modern_android_template.weather.compose

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.github.yangweigbh.modern_android_template.weather.data.Resource
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData

@Composable
fun HomeFragmentContent(weatherSummary: Resource<List<WeatherData>>?) {
    weatherSummary?.data?.let {
        LazyColumnFor(it) { weatherData ->
            Text(weatherData.toString())
        }
    } ?: Column {
        Text("Loading")
    }
}

@Preview
@Composable
fun HomeFragmentContentPreview() {
    HomeFragmentContent(Resource.success(listOf<WeatherData>(
        WeatherData("Beijing", "Sunny", 30),
        WeatherData("Tianjin", "Rainy", 38))))
}