package com.example.testtask.data

import com.example.testtask.utils.getAgeByDateOfBirth
import java.util.*

class Employee (
    val firstName: String,
    val lastName: String,
    val birthday: String,
    val avatarUrl: String,
    val specialties: List<Speciality>,
    val id: String = UUID.randomUUID().toString()
){
    fun getAge(): Int{
        return getAgeByDateOfBirth(birthday)
    }
}