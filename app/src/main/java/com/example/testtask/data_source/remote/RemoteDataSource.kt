package com.example.testtask.data_source.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.testtask.data.Employee
import com.example.testtask.data.Response
import com.example.testtask.data.Speciality
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class RemoteDataSource {
    interface Api {
        @GET("testTask.json")
        fun getData(): Call<Response>
    }

    val BASE_URL = "https://gitlab.65apps.com/65gb/static/raw/master/"
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: Api = retrofit.create(Api::class.java)


    val employees = MutableLiveData<List<Employee>>()
    val specialities = MutableLiveData<List<Speciality>>()


    fun refreshAll() {
        val call = retrofitService.getData()
        call.enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val employeesList = response.body()?.employees
                if (employeesList != null) {
                    employees.postValue(employeesList)
                    val specialitiesList = getSpecailities(employeesList)
                    specialities.postValue(specialitiesList)
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("myLog", t.toString())
            }

        });
    }

    private fun getSpecailities(employees: List<Employee>): List<Speciality> {
        val specialitiesSet = mutableSetOf<Speciality>()
        for (employee in employees) {
            var specialities = employee.specialties
            specialitiesSet.addAll(specialities)
        }
        return specialitiesSet.toList()
    }
}

