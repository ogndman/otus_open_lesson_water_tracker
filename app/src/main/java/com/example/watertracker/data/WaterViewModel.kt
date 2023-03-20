package com.example.watertracker.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watertracker.data.source.database.WaterEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WaterViewModel @Inject constructor(
    private val waterRepository: WaterRepository
) : ViewModel() {

    val totalAmount = MutableLiveData(0)
    val allPortions = MutableLiveData<List<WaterEntity>>()

    init {
        viewModelScope.launch {
            totalAmount.value = waterRepository.getTotalAmount()
        }
    }

    fun addWater(value: Int) {
        val oldValue = totalAmount.value ?: 0
        totalAmount.value = oldValue + value

        viewModelScope.launch {
            waterRepository.savePortion(amount = value)
        }
    }

    fun getAllPortions() {
        viewModelScope.launch {
            allPortions.value = waterRepository.getAllPortion()
        }
    }
}