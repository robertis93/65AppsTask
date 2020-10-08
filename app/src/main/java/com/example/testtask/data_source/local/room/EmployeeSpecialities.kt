package com.example.testtask.data_source.local.room

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality

@Entity(
    primaryKeys = ["idEmployee", "idSpeciality"],
    foreignKeys =[
    ForeignKey(entity = Employee::class, parentColumns = ["id"], childColumns =["idEmployee"]),
    ForeignKey(entity = Speciality::class, parentColumns =["id"], childColumns =["idSpeciality"])
    ]
)
data class EmployeeSpecialities(val idEmployee : String, val idSpeciality : Int)