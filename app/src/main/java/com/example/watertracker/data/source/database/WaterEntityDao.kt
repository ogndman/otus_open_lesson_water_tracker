package com.example.watertracker.data.source.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WaterEntityDao {

    @Query("SELECT * FROM waterentity")
    fun getAll(): List<WaterEntity>

    @Query("SELECT * FROM waterentity WHERE created_date=:date")
    fun getAllByDate(date: String): List<WaterEntity>

    @Insert
    fun add(waterEntity: WaterEntity)
}