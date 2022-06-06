package com.practice.architechurecomponent.utils.apicall

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleyService(context : Context) {
    companion object {
        @Volatile
        private var instance: VolleyService? = null
        fun getInstance(context: Context) = instance?: synchronized(this){
            instance?: VolleyService(context)
        }
    }

    val requestQueue: RequestQueue by lazy {

        Volley.newRequestQueue(context.applicationContext)
    }
    fun <T> addToRequestQueue(req: Request<T>){
        requestQueue.add(req)
    }


}