package com.practice.architechurecomponent.database.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
const val CURRENT_MAIN_ID = 0
@Entity(tableName = "Main")
data class Main(
    val id_key: Int,
    val temp_main: String,
    val feels_like_main: String,
    val temp_min_main: String,
    val temp_max_main: String,
    val pressure_main: String,
    val humidity_main: String
) {
    @PrimaryKey(autoGenerate = true)
    private var id: Int = -1

    @ColumnInfo(name = "temp")
    private var temp: String = ""

    @ColumnInfo(name = "feels_like")
    private var feels_like: String = ""

    @ColumnInfo(name = "temp_min")
    private var temp_min: String = ""

    @ColumnInfo(name = "temp_max")
    private var temp_max: String = ""

    @ColumnInfo(name = "pressure")
    private var pressure: String = ""

    @ColumnInfo(name = "humidity")
    private var humidity: String = ""
}