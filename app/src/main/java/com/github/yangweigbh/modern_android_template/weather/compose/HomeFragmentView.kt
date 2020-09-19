package com.github.yangweigbh.modern_android_template.weather.compose

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.github.yangweigbh.modern_android_template.weather.data.Resource
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData

@Composable
fun HomeFragmentContent(weatherSummary: Resource<List<WeatherData>>?, onClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { onClick() }) {
                        Icon(Icons.Filled.Favorite)
                    }
                }
            )
        }
    ) { innerPadding ->
        weatherSummary?.data?.let {
            LazyColumnFor(it, modifier = Modifier.padding(innerPadding)) { weatherData ->
                Text(weatherData.toString())
            }
        } ?: Column(modifier = Modifier.padding(innerPadding)) {
            Text("Loading")
        }
    }


}

@Preview
@Composable
fun HomeFragmentContentPreview() {
    HomeFragmentContent(Resource.success(listOf<WeatherData>(
        WeatherData("Beijing", "Sunny", 30),
        WeatherData("Tianjin", "Rainy", 38)))
    ) {}
}