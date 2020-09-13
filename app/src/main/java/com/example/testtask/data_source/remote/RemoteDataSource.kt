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
				if (employeesList != null){
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

val json = """{
	"response" : [
		{
			"f_name" 	: "иВан",
			"l_name" 	: "ИваноВ",
			"birthday"	: "1987-03-23",
			"avatr_url"	: "https://2.cdn.echo.msk.ru/files/avatar2/2561900.jpg",
			"specialty" : [{
				"specialty_id" : 101,
				"name"	: "Менеджер"
			}]
		},
		{
			"f_name" 	: "Петр",
			"l_name" 	: "петроВ",
			"birthday"	: null,
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/1253126.jpg",
			"specialty" : [{
				"specialty_id" : 101,
				"name"	: "Менеджер"
			}]
		},
		{
			"f_name" 	: "Вася",
			"l_name" 	: "Пупкин",
			"birthday"	: "1985-11-29",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/1450682.jpg",
			"specialty" : [{
				"specialty_id" : 101,
				"name"	: "Менеджер"
			},
			{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "ЕКАТЕРИНА",
			"l_name" 	: "пертрова",
			"birthday"	: "1990-01-07",
			"avatr_url" : "",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Николай",
			"l_name" 	: "Сидоров",
			"birthday"	: "",
			"avatr_url" : null,
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Виктор",
			"l_name" 	: "Федотов",
			"birthday"	: "23-07-2000",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/2441412.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Артур",
			"l_name" 	: "ВАрламов",
			"birthday"	: "23-07-2000",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/808879.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Артур",
			"l_name" 	: "ВАрламов",
			"birthday"	: "23-07-1982",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/2933492.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Руслан",
			"l_name" 	: "Русанов",
			"birthday"	: "17-10-1984",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/844319.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Владимир",
			"l_name" 	: "Миронов",
			"birthday"	: "03-08-1972",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/3073407.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		}
	]
}"""