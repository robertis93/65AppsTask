package com.example.testtask.data_source.local

import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.local.room.RoomDB

class LocalDataSource (private val roomDB: RoomDB){

    val employees = roomDB.employeesDao().getEmployeesLiveData()
    val specialities = roomDB.specialitiesDao().getSpecialitiesLiveData()

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