package com.example.testtask.data

import androidx.room.*
import com.example.testtask.utils.formatDateOfBirth
import com.example.testtask.utils.getAgeByDateOfBirth
import com.example.testtask.utils.getSpecialitiesFromEmployee
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "Employees")
data class Employee(
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
) {
    @SerializedName(value = "specialty")
    @Ignore
    var specialties: MutableList<Speciality> = mutableListOf()

    fun getAge(): Int? {
        return getAgeByDateOfBirth(birthday)
    }

    fun trueFormatDateOfBirth(): String? {
        return formatDateOfBirth(birthday)
    }

    fun getSpecialities(): String {
        return getSpecialitiesFromEmployee(specialties)
    }

}
