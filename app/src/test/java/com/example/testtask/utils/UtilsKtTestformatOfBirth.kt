package com.example.testtask.utils

import org.junit.Test

import org.junit.Assert.*

class UtilsKtTestformatOfBirth {

    @Test
    fun formatDateOfBirth() {
        val dateOfBirth = null
        val age = "Дата рождения неизвестна"
        assertEquals(formatDateOfBirth(dateOfBirth), age)
    }
}