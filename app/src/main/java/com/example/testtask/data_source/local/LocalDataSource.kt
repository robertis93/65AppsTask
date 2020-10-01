package com.example.testtask.data_source.local

import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.local.room.RoomDB
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalDataSource (private val roomDB: RoomDB){

//    val employees = roomDB.employeesDao().getEmployeesLiveData()
//    val specialities = roomDB.specialitiesDao().getSpecialitiesLiveData()

    suspend fun getEmployees(): List<Employee>{
        return roomDB.employeesDao().getEmployees()
    }

    suspend fun getSpecialities(): List<Speciality>{
        return roomDB.specialitiesDao().getSpecialities()
    }

    suspend fun updateEmployees(employees: List<Employee>){
        roomDB.employeesDao().deleteAll()
        for (employee in employees)
            roomDB.employeesDao().insert(employee)
    }

    suspend fun updateSpescialities(spescialities: List<Speciality>){
        roomDB.specialitiesDao().deleteAll()
        for (speciality in spescialities)
            roomDB.specialitiesDao().insert(speciality)
    }

    suspend fun deleteSpeciality(spesciality: Speciality){
        roomDB.specialitiesDao().delete(spesciality)
    }
}