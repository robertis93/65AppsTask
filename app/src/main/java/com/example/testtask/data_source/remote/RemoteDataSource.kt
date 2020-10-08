package com.example.testtask.data_source.remote

import com.example.testtask.data.Employee
import com.example.testtask.data.Response
import com.example.testtask.data.Speciality
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class RemoteDataSource {
    interface Api {
        @GET("testTask.json")
        suspend fun getData(): Response
    }

    private val BASE_URL = "https://gitlab.65apps.com/65gb/static/raw/master/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: Api = retrofit.create(Api::class.java)

    suspend fun getEmployees(): List<Employee> {
        return retrofitService.getData().employees
    }

    suspend fun getSpecialities(): List<Speciality> {
        val employeesList = getEmployees()
        val specialitiesList = takeSpecailitiesFromEmployee(employeesList)
        return specialitiesList
    }

    private fun takeSpecailitiesFromEmployee(employees: List<Employee>): List<Speciality> {
        val specialitiesSet = mutableSetOf<Speciality>()
        for (employee in employees) {
            val specialities = employee.specialties
            specialitiesSet.addAll(specialities)
        }
        return specialitiesSet.toList()
    }
}

