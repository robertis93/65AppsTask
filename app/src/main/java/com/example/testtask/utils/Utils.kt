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

fun formatDateOfBirth(dateOfBirth: String): String {
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

    TODO("преобразовать ответ сервера к требуемому формату (число.месяц.год. Пример: 22.11.1987 г. В случае отсутствия даты, показывать прочерк ««)")
}

fun getAgeByDateOfBirth(dateOfBirth: String?): Int {
    return 0
//    val sdf = SimpleDateFormat("dd.MM.yyyy")
//    val currentDate = sdf.format(Date())
//    val dateCurrentIntYear = currentDate.substring(6..9).toInt()
//    val dateBirthIntYear = dateOfBirth.substring(6..9).toInt()
//    val dateCurrentIntMounth = currentDate.substring(3..4).toInt()
//    val dateBirthIntMounth = dateOfBirth.substring(3..4).toInt()
//    val dateCurrentIntDay = currentDate.substring(0..1).toInt()
//    val dateBirthIntDay = dateOfBirth.substring(0..1).toInt()
//
//
//    if (dateBirthIntMounth - dateCurrentIntMounth > 0 && dateCurrentIntDay - dateBirthIntDay > 0)
//        return dateCurrentIntYear - dateBirthIntYear -1
//    else
//        return dateCurrentIntYear - dateBirthIntYear
//
//


}