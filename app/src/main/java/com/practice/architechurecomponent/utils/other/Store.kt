package com.practice.architechurecomponent.utils.other

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Store(context: Context) {
    private   var sharedPreferences: SharedPreferences = context.getSharedPreferences("localStore",MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = sharedPreferences.edit()
    public var latitude:String = ""
    set(value) {
        editor.putString("latitude",value).apply()
        field = value
    }
    get() {
        if (sharedPreferences.contains("latitude"))
        {
             field = sharedPreferences.getString("latitude","0.0").toString()
        }
        return field
    }
    public var longitude:String = ""
        set(value) {
            editor.putString("longitude",value).apply()
            field = value
        }
        get() {
            if (sharedPreferences.contains("longitude"))
            {
                field = sharedPreferences.getString("longitude","0.0").toString()
            }
            return field
        }

}