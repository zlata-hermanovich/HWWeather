package com.example.myweather.ui.weather.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myweather.databinding.ItemWeatherBinding
import com.example.myweather.model.Weather

class WeatherAdapter(private val context: Context):RecyclerView.Adapter<WeatherViewHolder>() {

    private var list= arrayListOf<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
      return WeatherViewHolder(context, ItemWeatherBinding.inflate(LayoutInflater.from(context)))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bindHour(list[position])

    }

    override fun getItemCount() = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(data: ArrayList<Weather>) {
        list = data
        notifyDataSetChanged()
    }
}