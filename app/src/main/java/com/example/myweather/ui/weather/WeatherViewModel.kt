package com.example.myweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweather.model.Weather
import com.example.myweather.repository.WeatherRepository

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    val listWeather = MutableLiveData<ArrayList<Weather>>()

    fun getListWeatherHour(city: String) {
        listWeather.value = repository.searchByHour(city)
    }

    fun getListWeatherDay(city: String) {
        listWeather.value = repository.searchWeatherByDays(city)
    }
}