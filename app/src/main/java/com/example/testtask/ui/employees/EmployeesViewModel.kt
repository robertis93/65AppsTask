package com.example.testtask.ui.employees

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.testtask.TestTaskApp.Companion.repository
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.Repository

class EmployeesViewModel(repository: Repository) : ViewModel() {
    private var specialityId: Int? = null
//    val employeesLiveData: LiveData<List<Employee>> = Transformations.map(repository.employees){employees ->
//        employees.filter { employee-> employee.specialties.find { it.id == specialityId } != null}
//    }

    fun initSpecialityId(specialityId: Int) {
        this.specialityId = specialityId
    }


    suspend fun getEmployees() = repository.getEmployees()
        .filter { employee -> employee.specialties.find { it.id == specialityId } != null }
}


