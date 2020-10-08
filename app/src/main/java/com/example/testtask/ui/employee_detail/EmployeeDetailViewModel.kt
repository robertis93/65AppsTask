package com.example.testtask.ui.employee_detail

import android.app.Application
import com.example.testtask.R
import androidx.lifecycle.*
import com.example.testtask.data.Employee
import com.example.testtask.data_source.Repository
import kotlinx.coroutines.launch

class EmployeeDetailViewModel(application: Application, val repository: Repository) : AndroidViewModel(application) {
    var employeeId: String? = null

    val employeeLiveData = MutableLiveData<Employee?>()

    init {
        viewModelScope.launch {
            val employee = repository.getEmployees().find { employee -> employee.id == employeeId }
            employeeLiveData.postValue(employee)
        }
    }

    val age = Transformations.map(employeeLiveData){employee->
        if (employee?.getAge() == null) {
            application.resources.getString(R.string.null_age)
        } else
            employee.getAge().toString()
    }
    val dateOfBirth = Transformations.map(employeeLiveData){employee->
        if (employee?.trueFormatDateOfBirth() == null) {
            application.resources.getString(R.string.null_birthday)
        } else
            employee.trueFormatDateOfBirth().toString()
    }

}