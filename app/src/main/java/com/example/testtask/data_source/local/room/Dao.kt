package com.example.testtask.data_source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality

@Dao
interface EmployeeDAO{
    @Query("SELECT * FROM employees")
    fun getEmployeesLiveData(): LiveData<List<Employee>>

    @Insert
    fun insert(employee: Employee)

    @Update
    fun update(employee: Employee)

    @Delete
    fun delete(employee: Employee)

    @Query("DElETE FROM employees")
    fun deleteAll()
}

@Dao
interface SpecialitiesDAO{
    @Query("SELECT * FROM specialities")
    fun getSpecialitiesLiveData(): LiveData<List<Speciality>>

    @Insert
    fun insert(speciality: Speciality)

    @Update
    fun update(speciality: Speciality)

    @Delete
    fun delete(speciality: Speciality)

    @Query("DElETE FROM specialities")
    fun deleteAll()
}

