package com.example.testtask.data_source

import com.example.testtask.data_source.local.LocalDataSource
import com.example.testtask.data_source.remote.RemoteDataSource

class Repository (private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource){
    val employees = localDataSource.employees
    val specialities = localDataSource.specialities
    init {
        remoteDataSource.employees.observeForever {
            //"сохранить список сотрудников в локальную БД"
            localDataSource.updateEmployees(it)
        }
        remoteDataSource.specialities.observeForever {
            //"сохранить список специальностей в локальную БД"
            localDataSource.updateSpescialities(it)
        }
    }

    fun refreshAll(){
        remoteDataSource.refreshAll()
    }
}