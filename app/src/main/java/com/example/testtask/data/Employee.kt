package com.example.testtask.data

import androidx.room.*
import com.example.testtask.utils.formatDateOfBirth
import com.example.testtask.utils.getAgeByDateOfBirth
import com.example.testtask.utils.getSpecialitiesFromEmployee
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.util.*

@Entity(tableName = "Employees")
data class Employee (
    @SerializedName(value = "f_name")
    val firstName: String = "",
    @SerializedName(value = "l_name")
    val lastName: String = "",
    @SerializedName(value = "birthday")
    val birthday: String? = "",
    @SerializedName(value = "avatr_url")
    val avatarUrl: String? = "",
    @PrimaryKey
    val id: String = UUID.randomUUID().toString()
){
    @TypeConverters(ListSpecialitiesTypeConverter::class)
    @SerializedName(value = "specialty")
    var specialties: List<Speciality> = emptyList()
    fun getAge(): Int? {
        return getAgeByDateOfBirth(birthday)
    }

    fun trueFormatDateOfBirth(): String? {
        return formatDateOfBirth(birthday)
    }
    fun getSpecialities() : String {
        return getSpecialitiesFromEmployee(specialties)
    }

}


class ListSpecialitiesTypeConverter{
    @TypeConverter
    fun fromDB(json: String): List<Speciality>{
        val specialityType = object : TypeToken<List<Speciality>>() {}.type
        val list = Gson().fromJson<List<Speciality>>(json, specialityType)
        return list
    }

    @TypeConverter
    fun toDB(list: List<Speciality>): String{
        return Gson().toJson(list)
    }
}