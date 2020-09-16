package com.github.yangweigbh.modern_android_template.weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.livedata.observeAsState
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.NavHostFragment
import com.github.yangweigbh.modern_android_template.R
import com.github.yangweigbh.modern_android_template.weather.data.Resource
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData
import com.github.yangweigbh.modern_android_template.weather.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.platform.ComposeView

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    val weatherSummary = viewModel.weatherSummary.observeAsState().value

                    weatherSummary?.data?.let {
                        Column {
                            for (i in weatherSummary.data) {
                                Text(i.toString())
                            }
                        }
                    } ?: Column {
                        Text("Loading")
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getData();
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }
}