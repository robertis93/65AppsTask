package com.example.testtask.ui.employee_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.testtask.data.Employee
import com.example.testtask.data_source.Repository

class EmployeeDetailViewModel(val repository: Repository) : ViewModel() {
    private var employeeId: String? = null
    fun initEmployeeId(employeeId: String){
        this.employeeId = employeeId
    }

    val employeeLiveData: LiveData<Employee> = Transformations.map(repository.employees){employees ->
        employees.find { employee -> employee.id == employeeId }
    }
}