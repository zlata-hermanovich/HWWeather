package com.example.myweather.database

import com.example.myweather.model.*
import kotlin.random.Random

object CityDataBase {

    val listCity: ArrayList<String> = arrayListOf("Minsk", "Brest")

    val listWeatherHour = arrayListOf(
        WeatherForCity(
            "Minsk",
            arrayListOf(
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty())
            )
        ),
        WeatherForCity(
            "Brest",
            arrayListOf(
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty())
            )
        )
    )

    val listWeatherDay = arrayListOf(
        WeatherForCity(
            "Minsk",
            arrayListOf(
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty())
            )
        ),
        WeatherForCity(
            "Brest",
            arrayListOf(
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty()),
                Weather(randWeather(), randNasty())
            )
        )
    )

    fun randWeather(): Int {
        return (-4..4).random()
    }

    fun randNasty(): Boolean {
        return Random.nextBoolean()
    }
}