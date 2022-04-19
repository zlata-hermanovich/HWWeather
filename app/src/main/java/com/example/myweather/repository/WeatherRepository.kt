package com.example.myweather.repository

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import com.cesarferreira.tempo.*
import com.example.myweather.database.CityDataBase
import com.example.myweather.model.Weather
import java.util.*
import kotlin.collections.ArrayList

object WeatherRepository {

    fun searchByHour(city: String): ArrayList<Weather> {
        val listWeather = CityDataBase.listWeatherHour.find { it.city == city }
            ?.listWeather ?: arrayListOf()

        val date = Date()
        val calendar = GregorianCalendar.getInstance()
        calendar.time = date
        var hour = calendar.get(Calendar.HOUR)+12

        listWeather.forEach {
            if (hour == 23 || hour == 24) {
                hour = 0
                it.time = (hour + 2).toString()+":00"
                hour += 2
            } else {
                it.time = (hour + 2).toString()+":00"
                hour += 2
            }
        }
        return listWeather
    }

    @SuppressLint("SimpleDateFormat")
    fun searchWeatherByDays(city: String): ArrayList<Weather> {
        val listWeather = CityDataBase.listWeatherDay.find { it.city == city }
            ?.listWeather ?: arrayListOf()

        var day:Date=Tempo.now

        val dayWeek = SimpleDateFormat("EE")
        var dayName = dayWeek.format(day)

        listWeather.forEach {
            it.time = dayName
            day+=(1.day)
            dayName = dayWeek.format(day)
        }
        return listWeather
    }
}



