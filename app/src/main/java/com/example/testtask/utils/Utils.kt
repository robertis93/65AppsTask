package com.example.testtask.utils


import com.example.testtask.data.Speciality
import java.text.SimpleDateFormat
import java.util.*


fun formatEmployeeName(firstName: String): String {
    return firstName.toLowerCase().capitalize()
}

fun formatDateOfBirth(dateOfBirth: String?): String? {
    if (dateOfBirth.isNullOrEmpty()) {
        return null
    } else {
        val symbol = dateOfBirth.indexOf('-')
        val year = dateOfBirth.substring(0..symbol - 1)
        val right = dateOfBirth.substring(symbol + 1) //03-23
        val symbol2 = right.indexOf('-')  //2
        val mounth = right.substring(0..symbol2 - 1)  //03
        val right2 = right.substring(symbol2 + 1)
        var symbol3 = right2.indexOf('-')
        val day = right2.substring(0)

        return if (symbol > 3)
            "$day.$mounth.$year"
        else "$year.$mounth.$day"
    }
}

fun getAgeByDateOfBirth(dateOfBirth: String?): Int? {

    val employeeDateOfBirth = formatDateOfBirth(dateOfBirth)
    if (employeeDateOfBirth == null)
        return null
    val nowingDate = SimpleDateFormat("dd.MM.yyyy")
    val currentDate = nowingDate.format(Date())
    val dateCurrentIntYear = currentDate.substring(6..9).toInt()
    val dateCurrentIntMounth = currentDate.substring(3..4).toInt()
    val dateCurrentIntDay = currentDate.substring(0..1).toInt()
    val dateBirthIntYear = employeeDateOfBirth?.substring(6..9)?.toInt()
    val dateBirthIntMounth = employeeDateOfBirth.substring(3..4)?.toInt()
    val dateBirthIntDay = employeeDateOfBirth.substring(0..1)?.toInt()
    val yearsEmployee = dateCurrentIntYear - dateBirthIntYear!!
    return if (dateBirthIntDay > dateCurrentIntDay && dateCurrentIntMounth >= dateBirthIntMounth) {
        yearsEmployee
    } else if (dateCurrentIntMounth <= dateBirthIntMounth) {
        yearsEmployee - 1
    } else (yearsEmployee)
}

fun getSpecialitiesFromEmployee(specialties: List<Speciality>) = specialties.map{it.name}.toString()


