package com.example.testtask.utils

import android.app.Application
import androidx.room.Room
import com.example.testtask.data_source.Repository
import com.example.testtask.data_source.local.LocalDataSource
import com.example.testtask.data_source.local.room.RoomDB
import com.example.testtask.data_source.remote.RemoteDataSource

class TestTask : Application() {
    companion object{
        lateinit var repository: Repository
    }

    override fun onCreate() {
        super.onCreate()
        val roomDB = Room.databaseBuilder(applicationContext, RoomDB::class.java, "db").allowMainThreadQueries().build()
        repository = Repository(LocalDataSource(roomDB), RemoteDataSource())//") //Dagger2 (Dependency in injection) || ServiceLocator
        repository.refreshAll()
    }
}