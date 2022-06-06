package com.practice.architechurecomponent.database.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Wind")
data class Wind(
    val id_wind: Int,
    val speed_wind: Double,
    val deg_wind: Int,
    val gust_wind: Double
) {
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "speed")
    private var speed: Double = 0.0

    @ColumnInfo(name = "deg")
    private var deg: Int = 0

    @ColumnInfo(name = "qust")
    private var gust: Double = 0.0
}