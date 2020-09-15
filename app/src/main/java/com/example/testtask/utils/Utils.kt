package com.example.testtask.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

fun myLog(msg: String) = Log.d("myLog", msg)

fun formatEmployeeFirstName(firstName: String): String {
    return firstName.toLowerCase().capitalize()
}

fun formatEmployeeLastName(lastName: String): String {
    return lastName.toLowerCase().capitalize()
}

fun formatDateOfBirth(dateOfBirth: String?): String {
    if (dateOfBirth == null || dateOfBirth == "") {
        return "Дата рождения неизвестна"
    } else {
        var symbol = dateOfBirth.indexOf('-')
        var year = dateOfBirth.substring(0..symbol - 1)
        var right = dateOfBirth.substring(symbol + 1) //03-23
        var symbol2 = right.indexOf('-')  //2
        var mounth = right.substring(0..symbol2 - 1)  //03
        var right2 = right.substring(symbol2 + 1)
        var symbol3 = right2.indexOf('-')
        var day = right2.substring(0)

        return if (symbol > 3)
            "$day.$mounth.$year"
        else "$year.$mounth.$day"
    }
}

 fun getAgeByDateOfBirth(dateOfBirth: String?): Int? {

    val employeeDateOfBirth = formatDateOfBirth(dateOfBirth)
     if (employeeDateOfBirth== "Дата рождения неизвестна")
         return 0
     val nowingDate =  SimpleDateFormat("dd.MM.yyyy")
     val currentDate = nowingDate.format(Date())
     val dateCurrentIntYear = currentDate.substring(6..9).toInt()
     val dateCurrentIntMounth = currentDate.substring(3..4).toInt()
     val dateCurrentIntDay = currentDate.substring(0..1).toInt()
    val dateBirthIntYear = employeeDateOfBirth?.substring(6..9)?.toInt()
    val dateBirthIntMounth = employeeDateOfBirth.substring(3..4)?.toInt()
    val dateBirthIntDay = employeeDateOfBirth.substring(0..1)?.toInt()


     val yearsEmployee = dateCurrentIntYear - dateBirthIntYear!!
     return if ( dateBirthIntDay>dateCurrentIntDay && dateCurrentIntMounth>=dateBirthIntMounth){
         yearsEmployee
     } else if (dateCurrentIntMounth<=dateBirthIntMounth) {


         yearsEmployee - 1
     } else (yearsEmployee)


}

