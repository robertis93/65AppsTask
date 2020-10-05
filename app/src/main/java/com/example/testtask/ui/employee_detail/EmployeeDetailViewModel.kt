package com.example.testtask.ui.employee_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.testtask.data.Employee
import com.example.testtask.data_source.Repository

class EmployeeDetailViewModel(val repository: Repository) : ViewModel() {
/*    var employeeId: String? = null

    val employeeLiveData = Transformations.map(repository.employeesLiveData){ employees ->
        employees.find { employee -> employee.id == employeeId}
    }*/
    suspend fun getEmployeeDetail(employeeId: String): Employee? = repository.getEmployees().find { employee -> employee.id == employeeId}
}