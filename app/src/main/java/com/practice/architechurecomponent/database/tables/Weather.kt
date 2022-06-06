package com.practice.architechurecomponent.database.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.properties.Delegates

@Entity(tableName = "Weather")
data class Weather(
    val id_key: Int,
    val main_weather: String,
    val description_weather: String,
    val icon_weather: String
) {
    @PrimaryKey(autoGenerate = true)
    private var id: Int = -1

    @ColumnInfo(name = "main")
    private var main: String = ""

    @ColumnInfo(name = "description")
    private var description: String = ""

    @ColumnInfo(name = "icon")
    private var icon: String = ""

}