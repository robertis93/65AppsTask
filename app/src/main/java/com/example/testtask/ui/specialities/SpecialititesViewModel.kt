package com.example.testtask.ui.specialities

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.testtask.data_source.Repository

class SpecialititesViewModel(private val repository: Repository) : ViewModel() {
    val specialitiesLiveData = Transformations.map(repository.specialities){
        it.sortedBy { it.name }
    }
}