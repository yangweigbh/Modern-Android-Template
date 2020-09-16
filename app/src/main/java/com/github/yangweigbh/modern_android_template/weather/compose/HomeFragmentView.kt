package com.github.yangweigbh.modern_android_template.weather.compose

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.github.yangweigbh.modern_android_template.weather.data.Resource
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData

@Composable
fun HomeFragmentContent(weatherSummary: Resource<List<WeatherData>>?) {
    weatherSummary?.data?.let {
        Column {
            for (i in it) {
                Text(i.toString())
            }
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