package com.example.testtask.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Specialities")
class Speciality (
    @PrimaryKey
    val id: Int = -1,
    val name: String = ""
)