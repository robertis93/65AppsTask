package com.example.testtask.data

import androidx.room.*
import com.example.testtask.utils.getAgeByDateOfBirth
import java.util.*

@Entity(tableName = "Employees")
class Employee (
    val firstName: String = "",
    val lastName: String = "",
    val birthday: String = "",
    val avatarUrl: String = "",
    @TypeConverters(ListSpecialitiesTypeConverter::class)
    val specialties: List<Speciality> = emptyList(),
    @PrimaryKey
    val id: String = UUID.randomUUID().toString()
){

    fun getAge(): Int{
        return getAgeByDateOfBirth(birthday)
    }
}


class ListSpecialitiesTypeConverter{
    @TypeConverter
    fun fromDB(json: String): List<Speciality>{
        TODO() //GSON
    }

    @TypeConverter
    fun toDB(list: List<Speciality>): String{
        TODO()
    }
}