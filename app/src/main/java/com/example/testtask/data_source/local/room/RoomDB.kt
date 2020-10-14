package com.example.testtask.data_source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality

@Database(entities = [Employee::class, Speciality::class, EmployeeSpeciality::class], version = 1)
abstract class RoomDB: RoomDatabase(){
    abstract fun employeesDao(): EmployeeDAO
    abstract fun specialitiesDao(): SpecialitiesDAO
    abstract fun employeesSpecialitiesDAO(): EmployeesSpecialitiesDAO
}