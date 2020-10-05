package com.example.testtask.ui.employee_detail

import androidx.lifecycle.*
import com.example.testtask.data.Employee
import com.example.testtask.data_source.Repository
import kotlinx.coroutines.launch

class EmployeeDetailViewModel(val repository: Repository) : ViewModel() {
    var employeeId: String? = null

    val employeeLiveData = MutableLiveData<Employee?>()
    init {
        viewModelScope.launch {
            val employee = repository.getEmployees().find { employee -> employee.id == employeeId}
            employeeLiveData.postValue(employee)
        }
    }
    //suspend fun getEmployeeDetail(employeeId: String): Employee? = repository.getEmployees().find { employee -> employee.id == employeeId}
}