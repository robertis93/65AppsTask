package com.example.testtask.data_source.local

import androidx.lifecycle.MutableLiveData
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality

class LocalDataSource (){
    val employees = MutableLiveData<List<Employee>>() //связать с содержимым локальной БД через Room
    val specialities = MutableLiveData<List<Speciality>>() //связать с содержимым локальной БД через Room
    fun updateEmployees(employees: List<Employee>){
        TODO("сохранить список employees в локальную БД с помощью Room")
    }

    fun updateSpescialities(spescialities: List<Speciality>){
        TODO("сохранить список spescialities в локальную БД с помощью Room")
    }
}