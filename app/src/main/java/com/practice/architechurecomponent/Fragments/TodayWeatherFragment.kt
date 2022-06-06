package com.practice.architechurecomponent.Fragments

import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.JsonObject
import com.practice.architechurecomponent.R
import com.practice.architechurecomponent.databinding.FragmentTodayWeatherBinding
import com.practice.architechurecomponent.utils.apicall.VolleyService
import com.practice.architechurecomponent.utils.other.Store
import org.json.JSONObject


class TodayWeatherFragment : Fragment(R.layout.fragment_today_weather) {
    val API_KEY = "c079657f7715115a50df80e961218c77"
    private lateinit var binding: FragmentTodayWeatherBinding
    private lateinit var store: Store
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTodayWeatherBinding.bind(view)
        innit()
        parseJson()

    }

    private fun parseJson() {
        val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?lat=${store.latitude}&lon=${store.longitude}&appid=$API_KEY"
        val requestVolley: StringRequest = object : StringRequest(Method.GET, BASE_URL,
            Response.Listener { response ->
                Log.d("volleyResponse___", "" + response.toString())
                var parentJson = JSONObject(response.toString())

                var visibility = parentJson.getString("visibility")
                var dt  = parentJson.getString("dt")
                var timezone = parentJson.getString("timezone")
                var id = parentJson.get("timezone")
                var name = parentJson.get("name")
                var cod = parentJson.getString("cod")
                var base = parentJson.get("base")

                Log.d("visibility","visibility"+visibility)
                Log.d("dt","dt"+dt)
                Log.d("timezone","timezone"+timezone)
                Log.d("id","id"+id)
                Log.d("name","name"+name)
                Log.d("cod","cod"+cod)
                Log.d("base","base"+cod)


                var coord = parentJson.getJSONObject("coord")

                Log.d("coord___",""+coord)

                var weatherArray = parentJson.getJSONArray("weather")
                Log.d("weatherArray",""+weatherArray)

                for (index in 0 until weatherArray.length())
                {
                    var id = weatherArray.getJSONObject(index).getString("id")
                    var main = weatherArray.getJSONObject(index).getString("main")
                    var description = weatherArray.getJSONObject(index).getString("description")
                    var icon = weatherArray.getJSONObject(index).getString("icon")
                    Log.d("arrayITem__","id->"+id+"main->"+main+"description->"+description+"icon->"+icon)
                }
                val main = parentJson.getJSONObject("main")
                Log.d("main",""+main)

                val wind = parentJson.getJSONObject("wind")
                Log.d("wind",""+wind)

                val clouds = parentJson.getJSONObject("clouds")
                Log.d("clouds",""+clouds)

                val sys = parentJson.getJSONObject("sys")
                Log.d("sys",""+sys)







            },
            Response.ErrorListener { error ->
                Log.d("volleyError___", "" + error.toString())
            }) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["lat"] = 30.2.toString()
                params["lon"] = 78.05.toString()
                params["appid"] = "c079657f7715115a50df80e961218c77"
                return params
            }

        }
        activity?.let {
            VolleyService.getInstance(it.applicationContext).requestQueue.add(
                requestVolley
            )
        }
    }

    private fun innit() {
        store = activity?.let { Store(it.applicationContext) }!!
    }

}