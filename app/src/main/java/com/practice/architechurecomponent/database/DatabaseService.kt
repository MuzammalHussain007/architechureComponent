package com.practice.architechurecomponent.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.practice.architechurecomponent.database.dao.DAO
import com.practice.architechurecomponent.database.tables.Main
import com.practice.architechurecomponent.database.tables.Other
import com.practice.architechurecomponent.database.tables.Weather
import com.practice.architechurecomponent.database.tables.Wind

@Database(
    version = 1,
    entities = [
        Wind::class,
        Other::class ,
        Main::class ,
        Weather::class
               ]

)
abstract class DatabaseService : RoomDatabase(){
    abstract fun dao():DAO
    companion object{
        private var instance : DatabaseService? =null
        private val anyLock = Any()

        operator fun invoke(context:Context) = instance?: synchronized(anyLock){
            instance ?: buildDatabaseService(context)
        }
        private fun buildDatabaseService(context:Context)=
            Room.databaseBuilder(
                context.applicationContext,
                DatabaseService::class.java,"Weather.db"
            ).build()
    }


}