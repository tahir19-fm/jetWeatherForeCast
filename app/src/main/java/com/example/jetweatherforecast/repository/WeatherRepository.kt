package com.example.jetweatherforecast.repository

import android.util.Log
import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api:WeatherApi){
    suspend fun getWeather(cityQuery: String, units: String):DataOrException<Weather,Boolean,Exception>{
        val responce=try {
            Log.d("dsadsd", "getWeather: ")

            api.getWeather(query = cityQuery, units = units)

        }catch (e:Exception){
            Log.d("dsadsd", "getWeather:${e} ")
return DataOrException(e=e)
        }

return DataOrException(data = responce)
    }
}