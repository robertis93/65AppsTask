package com.example.testtask.ui.employees

import androidx.lifecycle.ViewModel
import com.example.testtask.TestTaskApp.Companion.repository
import com.example.testtask.data_source.Repository

class EmployeesViewModel(repository: Repository) : ViewModel() {
    private var specialityId: Int? = null


    fun initSpecialityId(specialityId: Int) {
        this.specialityId = specialityId
    }


    suspend fun getEmployees() = repository.getEmployees()
        .filter { employee -> employee.specialties.find { it.id == specialityId } != null }
}


