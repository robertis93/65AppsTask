package com.example.testtask.data_source.remote

import androidx.lifecycle.MutableLiveData
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality
import com.example.testtask.utils.myLog
import retrofit2.http.GET
import retrofit2.http.Query

class RemoteDataSource {
    interface Api{
        @GET("testTask.json")
        fun getData()
    }
    val employees = MutableLiveData<List<Employee>>()
    val specialities = MutableLiveData<List<Speciality>>()
    val BASE_URL = "https://gitlab.65apps.com/65gb/static/raw/master/"


    //retrofit || okhttp
    fun getJson(): String{
        return json
    }

    //GSON || kotlin Serialization
    fun parseJson(json: String){
        myLog(json)
        TODO()
        //employees.value = ...
        //specialities.value = ...
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