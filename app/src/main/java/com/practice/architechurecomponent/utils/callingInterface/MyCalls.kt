package com.practice.architechurecomponent.utils.callingInterface

import com.practice.architechurecomponent.utils.response.currentWeather.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import retrofit2.http.GET
import retrofit2.http.Query

interface MyCalls {
    @GET("/data/2.5/weather")
   suspend fun getCurrentWeather(
        @Query("lat") latitude :String,
        @Query("long") longitude : String,
        @Query("appid") id:String
    ) : CurrentWeatherResponse
}