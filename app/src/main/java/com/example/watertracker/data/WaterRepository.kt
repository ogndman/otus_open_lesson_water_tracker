package com.example.watertracker.data

import com.example.watertracker.data.source.database.WaterEntity

interface WaterRepository {
    suspend fun getTotalAmount(): Int
    suspend fun getAllPortion(): List<WaterEntity>
    suspend fun savePortion(amount: Int)
}