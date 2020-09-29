package com.example.testtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.testtask.R
import com.example.testtask.data_source.Repository
import com.example.testtask.data_source.local.LocalDataSource
import com.example.testtask.data_source.local.room.RoomDB
import com.example.testtask.data_source.remote.RemoteDataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}