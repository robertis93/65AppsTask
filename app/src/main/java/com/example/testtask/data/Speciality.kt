package com.example.testtask.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Specialities")
data class Speciality (
    @PrimaryKey
    @SerializedName(value = "specialty_id")
    val id: Int = -1,
    val name: String = ""
)