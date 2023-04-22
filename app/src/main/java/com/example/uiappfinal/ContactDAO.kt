package com.example.uiappfinal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface ContactDAO {
    @Insert(onConflict = REPLACE)
    fun insert(contact: Contacto)


    @Delete()
    fun delete(contact: Contacto)


    @Query("SELECT * FROM Contacto ORDER BY name ASC")
    fun loadAllContacts(): List<Contacto>


    @Query("SELECT * FROM Contacto")
    fun checkDb(): Boolean


    @Query("UPDATE Contacto SET name = :name, surname = :surname, birthDate = :birthDate, email = :email WHERE phone = :phone")
    fun updateContact(name: String, surname: String, birthDate: String, email: String, phone: String)

}