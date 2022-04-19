package com.example.myweather.ui.city

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.myweather.database.CityDataBase
import com.example.myweather.databinding.FragmentAddCityBinding
import com.example.myweather.model.*

class AddCityFragment : Fragment() {

    lateinit var binding: FragmentAddCityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCityBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addCityButton.setOnClickListener {
            AddCityDialogAgree().show(parentFragmentManager, "")
            binding.addCityEditText.setText("")
            it.hideKeyboard()
        }
    }

    fun addCity() {
        val city = binding.addCityEditText.text.toString()
        if (city !in CityDataBase.listCity) {

            CityDataBase.listCity.add(city)

            CityDataBase.listWeatherHour.add(
                WeatherForCity(
                    city,
                    arrayListOf(
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty())
                    )
                )
            )
            CityDataBase.listWeatherDay.add(
                WeatherForCity(
                    city,
                    arrayListOf(
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty()),
                        Weather(CityDataBase.randWeather(), CityDataBase.randNasty())
                    )
                )
            )
        }
    }

    //закрытие клавиатуры
    private fun View.hideKeyboard() {
        val inputManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}