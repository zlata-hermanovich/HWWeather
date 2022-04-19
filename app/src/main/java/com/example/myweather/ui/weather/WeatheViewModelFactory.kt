package com.example.myweather.ui.weather
import com.example.myweather.database.BaseViewModelFactory
import  com.example.myweather.repository.WeatherRepository

class WeatherViewModelFactory() :
    BaseViewModelFactory< WeatherViewModel >(WeatherViewModel::class.java) {

    override fun createViewModel(): WeatherViewModel {
        return WeatherViewModel(WeatherRepository)
    }
}