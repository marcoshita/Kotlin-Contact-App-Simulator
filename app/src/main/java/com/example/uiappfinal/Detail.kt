package com.example.uiappfinal

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var phone = intent.getStringExtra("PHONE").toString()
        var name = intent.getStringExtra("NAME").toString()
        var surname = intent.getStringExtra("SURNAME").toString()
        var email = intent.getStringExtra("EMAIL").toString()
        var birthdate = intent.getStringExtra("BIRTHDATE").toString()
        supportFragmentManager.beginTransaction().add(R.id.detailContainer, DetailFragment.newInstance(phone, name, surname, email, birthdate), "DISPLAY").commit()

    }

}