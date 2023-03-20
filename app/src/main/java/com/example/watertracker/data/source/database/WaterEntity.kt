package com.example.watertracker.data.source.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WaterEntity(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "created_date") val createdDate: String,
    @ColumnInfo(name = "amount") val amount: Int
)