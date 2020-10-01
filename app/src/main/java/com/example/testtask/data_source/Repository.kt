package com.example.testtask.data_source

import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.local.LocalDataSource
import com.example.testtask.data_source.remote.RemoteDataSource
import com.example.testtask.utils.formatEmployeeName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Repository (private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource){
    suspend fun getSpecialities(forceRefresh: Boolean = false): List<Speciality>{
        if (forceRefresh){
            val specialitiesFromServer = remoteDataSource.getSpecialities()
            localDataSource.updateSpescialities(specialitiesFromServer)
            return specialitiesFromServer
        }
        val specialities = localDataSource.getSpecialities()
        return if (specialities.isNotEmpty())
            specialities
        else{
            val specialitiesFromServer = remoteDataSource.getSpecialities()
            localDataSource.updateSpescialities(specialitiesFromServer)
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
            for (employee in employees){
                val convertedEmploeey = employee.copy(
                    firstName =  formatEmployeeName(employee.firstName),
                    lastName =  formatEmployeeName(employee.lastName)
                )
                convertedEmploeey.specialties = employee.specialties
                employeeList.add(convertedEmploeey)
            }
            localDataSource.updateEmployees(employeeList)
            employeeList
        }
    }

    suspend fun deleteSpecialityFromLocalDB(speciality: Speciality){
        localDataSource.deleteSpeciality(speciality)
    }
}