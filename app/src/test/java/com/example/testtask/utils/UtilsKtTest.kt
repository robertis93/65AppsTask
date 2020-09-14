package com.example.testtask.utils

import org.junit.Test

import org.junit.Assert.*

class UtilsKtTest {

    @Test
    fun `getAgeByDateOfBirth input correct date return date`() {
        val dateOfBirth = "23-07-2000"
        val age = 20
        assertEquals(getAgeByDateOfBirth(dateOfBirth), age)
    }

    @Test
    fun `getAgeByDateOfBirth input null date return null`() {
        val dateOfBirth: String? = null
        val age = null
        //assertEquals(getAgeByDateOfBirth(dateOfBirth), age)
    }

    @Test
    fun `getAgeByDateOfBirth input empty string date return null`() {
        val dateOfBirth: String = ""
        val age = null
        assertEquals(getAgeByDateOfBirth(dateOfBirth), age)
    }
}