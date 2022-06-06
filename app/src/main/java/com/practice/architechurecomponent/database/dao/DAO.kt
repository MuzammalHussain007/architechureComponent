package com.practice.architechurecomponent.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.practice.architechurecomponent.database.tables.*

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMain(main: Main)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOther(other: Other)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weather: Weather)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWind(wind: Wind)

    @Query("select * from Main where id=$CURRENT_MAIN_ID")
    fun getMainData():LiveData<Main>

    @Query("select * from Other where id=$CURRENT_MAIN_ID")
    fun getOtherData():LiveData<Other>

    @Query("select * from Weather where id=$CURRENT_MAIN_ID")
    fun getWeatherData():LiveData<Weather>

    @Query("select * from Wind where id=$CURRENT_MAIN_ID")
    fun getWindData():LiveData<Wind>


}