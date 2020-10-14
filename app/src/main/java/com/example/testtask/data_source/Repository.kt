package com.example.testtask.data_source

import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.local.LocalDataSource
import com.example.testtask.data_source.remote.RemoteDataSource
import com.example.testtask.utils.formatEmployeeName

class Repository (private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource){
    suspend fun getSpecialities(forceRefresh: Boolean = false): List<Speciality>{
        if (forceRefresh){
            val specialitiesFromServer = remoteDataSource.getSpecialities()
            localDataSource.updateSpecialities(specialitiesFromServer)
            return specialitiesFromServer
        }
        val specialities = localDataSource.getSpecialities()
        return if (specialities.isNotEmpty())
            specialities
        else{
            val specialitiesFromServer = remoteDataSource.getSpecialities()
            localDataSource.updateSpecialities(specialitiesFromServer)
            specialitiesFromServer
        }
    }

    suspend fun getEmployees(): List<Employee>{
        val employees = localDataSource.getEmployees()
        return if (employees.isNotEmpty())
            employees
        else{
            val employeesFromServer = remoteDataSource.getEmployees()
            val employeeList = mutableListOf<Employee>()
            for (employee in employeesFromServer){
                val convertedEmployee = employee.copy(
                    firstName =  formatEmployeeName(employee.firstName),
                    lastName =  formatEmployeeName(employee.lastName)
                )
                convertedEmployee.specialties = employee.specialties
                employeeList.add(convertedEmployee)
            }
            localDataSource.updateEmployees(employeeList)
            employeeList
        }
    }

}