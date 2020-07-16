package com.example.testtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testtask.R
import com.example.testtask.data_source.Repository

class MainActivity : AppCompatActivity() { // android navigation components
    lateinit var repository: Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TODO("repository = Repository()") //Dagger2 (Dependency in injection) || ServiceLocator
        setContentView(R.layout.activity_main)
    }
}