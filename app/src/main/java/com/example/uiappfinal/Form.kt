package com.example.uiappfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uiappfinal.DetailFragment.Companion.newInstance
import com.example.uiappfinal.FormFragment.Companion.newInstance

class Form : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        supportFragmentManager.beginTransaction().add(R.id.formContainer, FormFragment.newInstance(), "DISPLAY").commit()

    }
}