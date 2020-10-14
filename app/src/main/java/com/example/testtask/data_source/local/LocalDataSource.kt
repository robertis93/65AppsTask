package com.example.testtask.data_source.local

import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.local.room.EmployeeSpeciality
import com.example.testtask.data_source.local.room.RoomDB

class LocalDataSource(private val roomDB: RoomDB) {

    suspend fun getEmployees(): List<Employee> {
        val employees =  roomDB.employeesDao().getEmployees()
        val specialities = roomDB.specialitiesDao().getSpecialities()
        for (employee in employees){
            val specialityOfEmployee = roomDB.employeesSpecialitiesDAO().getSpecialities(employee.id)
            for (employeeSpeciality in specialityOfEmployee){
                val speciality = specialities.find{it.id == employeeSpeciality.idSpeciality}
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
        roomDB.employeesSpecialitiesDAO().deleteAll()
        for (employee in employees){
            roomDB.employeesDao().insert(employee)
            for (speciality in employee.specialties) {
                val employeeSpeciality = EmployeeSpeciality(employee.id, speciality.id)
                roomDB.employeesSpecialitiesDAO().insert(employeeSpeciality)
            }
        }
    }

    suspend fun updateSpecialities(specialities: List<Speciality>) {
        roomDB.specialitiesDao().deleteAll()
        for (speciality in specialities)
            roomDB.specialitiesDao().insert(speciality)
    }

}