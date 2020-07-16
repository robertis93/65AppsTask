package com.example.testtask.ui.employees

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.Repository

class EmployeesViewModel(repository: Repository) : ViewModel() {
    private var specialityId: Int? = null
    val employees = Transformations.map(repository.employees){employees ->
        employees.filter { employee-> employee.specialties.find { it.id == specialityId } != null}
    }

    fun initSpecialityId(specialityId: Int){
        this.specialityId = specialityId
    }
}