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
    @PrimaryKey
    val id: String = UUID.randomUUID().toString()
){
    @TypeConverters(ListSpecialitiesTypeConverter::class)
    var specialties: List<Speciality> = emptyList()
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