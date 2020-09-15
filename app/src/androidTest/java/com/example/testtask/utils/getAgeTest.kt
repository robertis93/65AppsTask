package com.example.testtask.utils

import org.junit.Test

import org.junit.Assert.*

class getAgeTest {

    @Test
    fun getAgeByDateOfBirthSecond() {
        val dateOfBirth = "1987-03-23"
        val age = 25
        assertEquals(formatDateOfBirth(dateOfBirth), age)
    }
}