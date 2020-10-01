package com.example.testtask.ui.specialities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.Repository
import kotlinx.coroutines.launch

class SpecialititesViewModel(private val repository: Repository) : ViewModel() {
    suspend fun getSpecialities(forceRefresh: Boolean = false) = repository.getSpecialities(forceRefresh).sortedBy { it.name }

//    val specialities = MutableLiveData<List<Speciality>>()
//
//    init{
//        viewModelScope.launch{
//            val specialitiesList = repository.getSpecialities()
//            specialities.value = specialitiesList
//        }
//    }
}