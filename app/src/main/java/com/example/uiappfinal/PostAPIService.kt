package com.example.uiappfinal

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPIService {
    @GET("contacts")
    fun getContactsFromApi(): Call<List<Contacto>>


}