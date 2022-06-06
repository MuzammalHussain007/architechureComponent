package com.practice.architechurecomponent.database.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Other")
data class Other(
    val id_Other: Int,
    val cityName_Other: String,
    val visibility_Other: String,
    val fetch_code_other:String
) {
    @PrimaryKey(autoGenerate = true)
    private val id: Int = 0

    @ColumnInfo(name = "cityName")
    private val cityName: String = ""

    @ColumnInfo(name = "visibility")
    private val visibility: String = ""


    @ColumnInfo(name = "fetch_code")
    private val fetch_code: String = ""
}