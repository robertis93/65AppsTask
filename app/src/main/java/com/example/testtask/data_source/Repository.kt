package com.example.testtask.data_source

import com.example.testtask.data.Employee
import com.example.testtask.data_source.local.LocalDataSource
import com.example.testtask.data_source.remote.RemoteDataSource
import com.example.testtask.utils.formatEmployeeFirstName

class Repository (private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource){
    val employees = localDataSource.employees
    val specialities = localDataSource.specialities
    init {
        remoteDataSource.employees.observeForever {employees ->
            val employeeList = mutableListOf<Employee>()
            for (employee in employees){
                val convertedEmploeey = employee.copy(
                    firstName =  formatEmployeeFirstName(employee.firstName),
                    lastName =  formatEmployeeFirstName(employee.lastName)
                )
                convertedEmploeey.specialties = employee.specialties
                employeeList.add(convertedEmploeey)
            }
            //"сохранить список сотрудников в локальную БД"
            localDataSource.updateEmployees(employeeList)
        }
        remoteDataSource.specialities.observeForever {
            //"сохранить список специальностей в локальную БД"
            localDataSource.updateSpescialities(it)
        }
    }

    fun refreshAll(){
        remoteDataSource.refreshAll()
    }
}