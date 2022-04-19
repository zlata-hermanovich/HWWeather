package com.example.myweather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myweather.R
import com.example.myweather.databinding.ActivityHomeBinding
import com.example.myweather.ui.city.AddCityFragment
import com.example.myweather.ui.weather.WeatherFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerAddCity, AddCityFragment())
            .commit()

        binding.bottomNavigationAdd.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.city_menu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.containerAddCity, AddCityFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.weather_menu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.containerAddCity, WeatherFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.settings_menu -> {
                    //do nothing
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener true
            }
        }
    }
}
