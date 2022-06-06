package com.practice.architechurecomponent.utils.apicall

import com.practice.architechurecomponent.utils.callingInterface.MyCalls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URI

class RetrofitService {

    companion object {
        private  val BASE_URL =  "https://api.openweathermap.org"
        private fun retrofitService(): Retrofit {
            return Retrofit.Builder()
                   .addConverterFactory(GsonConverterFactory.create())
                   .baseUrl(BASE_URL)
                   .build()
        }
        val callAPI : MyCalls by lazy {
            retrofitService().create(MyCalls::class.java)
        }
    }

}