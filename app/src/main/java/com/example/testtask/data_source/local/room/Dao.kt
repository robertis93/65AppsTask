package com.example.testtask.data_source.local.room

import androidx.room.*
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality

@Dao
interface EmployeeDAO {
    @Query("SELECT * FROM employees")
    suspend fun getEmployees(): List<Employee>

    @Insert
    suspend fun insert(employee: Employee)

    @Update
    suspend fun update(employee: Employee)

    @Delete
    suspend fun delete(employee: Employee)

    @Query("DElETE FROM employees")
    suspend fun deleteAll()
}

@Dao
interface SpecialitiesDAO {
    @Query("SELECT * FROM specialities")
    suspend fun getSpecialities(): List<Speciality>

    @Insert
    suspend fun insert(speciality: Speciality)

    @Update
    suspend fun update(speciality: Speciality)

    @Delete
    suspend fun delete(speciality: Speciality)

    @Query("DElETE FROM specialities")
    suspend fun deleteAll()
}

@Dao
interface EmployeesSpecialitiesDAO {
    @Query("SELECT * FROM EmployeeSpecialities")
    suspend fun getSpecialities(): List<EmployeeSpecialities>

    @Query("SELECT * FROM EmployeeSpecialities WHERE idEmployee = :idEmployee")
    suspend fun getSpecialities(idEmployee: String): List<EmployeeSpecialities>
}
