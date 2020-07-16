package com.example.testtask.ui.specialities

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.testtask.data_source.Repository

class SpecialititesViewModel(val repository: Repository) : ViewModel() {
    val specialities = Transformations.map(repository.specialities){
        it.sortedBy { it.name }
    }
}