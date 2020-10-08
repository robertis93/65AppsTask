package com.example.testtask.data_source.local

import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.local.room.RoomDB

class LocalDataSource(private val roomDB: RoomDB) {

    suspend fun getEmployees(): List<Employee> {
        val employees =  roomDB.employeesDao().getEmployees()
        val specilities = roomDB.specialitiesDao().getSpecialities()
        for (employee in employees){
            val employeeSpecilities = roomDB.employeesSpecialitiesDAO().getSpecialities(employee.id)
            for (employeeSpecility in employeeSpecilities){
                val speciality = specilities.find{it.id == employeeSpecility.idSpeciality}
                speciality?.let{
                    employee.specialties.add(speciality)
                }
            }
        }
        return employees
    }

    suspend fun getSpecialities(): List<Speciality> {
        return roomDB.specialitiesDao().getSpecialities()
    }

    suspend fun updateEmployees(employees: List<Employee>) {
        roomDB.employeesDao().deleteAll()
        for (employee in employees)
            roomDB.employeesDao().insert(employee)
    }

    suspend fun updateSpescialities(spescialities: List<Speciality>) {
        roomDB.specialitiesDao().deleteAll()
        for (speciality in spescialities)
            roomDB.specialitiesDao().insert(speciality)
    }

}