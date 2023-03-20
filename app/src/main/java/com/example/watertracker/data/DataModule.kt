package com.example.watertracker.data

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun provideWaterRepository(@ApplicationContext applicationContext: Context): WaterRepository {
        return WaterRepositoryImpl(applicationContext)
    }
}