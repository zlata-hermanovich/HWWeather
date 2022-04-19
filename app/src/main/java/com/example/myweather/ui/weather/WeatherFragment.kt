package com.example.myweather.ui.weather

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweather.database.CityDataBase
import com.example.myweather.databinding.FragmentHomeBinding
import com.example.myweather.model.Weather
import com.example.myweather.ui.weather.adapter.WeatherAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import kotlin.collections.ArrayList

class WeatherFragment : Fragment() {

    lateinit var viewModel: WeatherViewModel
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this, WeatherViewModelFactory())
            .get(WeatherViewModel::class.java)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //вызов функции дата и время
        showDataAndTime()

        //добавление списка городов в спинер
        binding.citySpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            CityDataBase.listCity
        )

        //обработка нажатия на элемент спинера
        binding.citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.resultTextView.text = CityDataBase.listCity[p2]
                viewModel.getListWeatherHour(CityDataBase.listCity[p2])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //do nothing
            }
        }

        binding.customHome.binding.buttonDay.setOnClickListener {
            viewModel.getListWeatherDay(binding.resultTextView.text.toString())
        }

        binding.customHome.binding.buttonHour.setOnClickListener {
            viewModel.getListWeatherHour(binding.resultTextView.text.toString())
        }

        viewModel.listWeather.observe(viewLifecycleOwner) {
            setList(it)
        }

        //тут нет проверки что именно отображается
        binding.refreshButton.setOnClickListener {
            viewModel.getListWeatherDay(binding.resultTextView.text.toString())
            viewModel.getListWeatherHour(binding.resultTextView.text.toString())
        }
    }

    //функция вывода даты и времени
    @RequiresApi(Build.VERSION_CODES.O)
    fun showDataAndTime() {
        val current = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.now()
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        binding.dataTextView.text = formatter.format(current)
    }

    //  -установка адаптера на список
    private fun setList(list: ArrayList<Weather>) {
        binding.weatherListRecycler.run {
            if (adapter == null) {
                adapter = WeatherAdapter(requireContext())
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as WeatherAdapter).setDataList(list)
        }
    }
}

