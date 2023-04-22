package com.example.uiappfinal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
data class Contacto(
    @PrimaryKey(autoGenerate = false) var phone: String,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "surname") var surname: String?,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "birthDate") var birthDate: String?,

)