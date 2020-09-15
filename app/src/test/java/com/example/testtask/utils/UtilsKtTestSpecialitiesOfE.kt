package com.example.testtask.utils

import org.junit.Test

import org.junit.Assert.*

class UtilsKtTestSpecialitiesOfE {

    @Test
    fun getSpecialitiesFromEmployee() {
        val dateOfBirth = "14-09-1993"
        val age = 26
        assertEquals(getAgeByDateOfBirth(dateOfBirth), age)
    }
}