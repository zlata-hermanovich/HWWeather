package com.example.myweather.model

data class Weather(val temperature: Int, val isNasty: Boolean, var time: String?="")

data class WeatherForCity(
    val city:String,
    val listWeather:ArrayList<Weather>)
