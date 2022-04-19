package com.example.myweather.ui.weather.adapter

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.myweather.R
import com.example.myweather.databinding.ItemWeatherBinding
import com.example.myweather.model.Weather

class WeatherViewHolder(
    private val context: Context,
    private val binding: ItemWeatherBinding
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    fun bindHour(item: Weather) {
        binding.weatherTextview.text = "${item.time}     temp: ${item.temperature}°C "

        val temp = item.temperature
        val nasty = item.isNasty
        when {
            (temp < -1 && nasty) -> binding.iconWeather.setImageDrawable(
                context.resources.getDrawable(
                    R.drawable.ic_sun_and_snow
                )
            )
            (nasty && temp > -2 && temp < 1) -> binding.iconWeather.setImageDrawable(
                context.resources.getDrawable(
                    R.drawable.ic_sky
                )
            )
            (nasty && temp > 1) -> binding.iconWeather.setImageDrawable(
                context.resources.getDrawable(
                    R.drawable.ic_sun_and_nasty
                )
            )
            else -> binding.iconWeather.setImageDrawable(context.resources.getDrawable(R.drawable.ic_sun))
        }
    }
}
