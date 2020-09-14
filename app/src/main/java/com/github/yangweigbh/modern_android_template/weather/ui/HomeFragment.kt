package com.github.yangweigbh.modern_android_template.weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.NavHostFragment
import com.github.yangweigbh.modern_android_template.R
import com.github.yangweigbh.modern_android_template.weather.data.WeatherData
import com.github.yangweigbh.modern_android_template.weather.data.WeatherDataSource
import com.github.yangweigbh.modern_android_template.weather.data.WeatherDataSourceImpl
import com.github.yangweigbh.modern_android_template.weather.data.WeatherRepository
import com.github.yangweigbh.modern_android_template.weather.viewmodel.HomeViewModel
import com.github.yangweigbh.modern_android_template.weather.viewmodel.HomeViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModeFactory: HomeViewModelFactory

    private val viewModel: HomeViewModel by viewModels {
        viewModeFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.weatherSummary.observe(viewLifecycleOwner) { result ->
            display(view, result)
        }

        view.findViewById<Button>(R.id.button).setOnClickListener {
            val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
            val navController = navHostFragment?.navController
            navController?.navigate(R.id.action_homeFragment_to_detailFragment)
        }
    }

    private fun display(view: View, result: List<WeatherData>) {
        view.findViewById<TextView>(R.id.text_view).setText(result.joinToString("\n"))
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