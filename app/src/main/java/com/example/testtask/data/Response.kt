package com.example.testtask.data


import com.google.gson.annotations.SerializedName

 data class Response(
    @SerializedName(value ="response") val employees: List<Employee>
)