package com.example.uiappfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.util.copy
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var db: AppDatabase
    val items: MutableList<Contacto> = mutableListOf()
    var itemSearch: MutableList<Contacto> = mutableListOf()
    lateinit var rvItems: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.button)
        rvItems = findViewById<RecyclerView>(R.id.rv_list)

        rvItems.adapter= ListAdapter(itemSearch, this, this)
        rvItems.layoutManager= LinearLayoutManager(this)

        db = AppDatabase.getInstance(applicationContext)!!


        GlobalScope.launch {
          if (db.ContactDAO().checkDb() == false){
                val call = getRetrofit().create(PostAPIService::class.java).getContactsFromApi().execute()
                val contactsToInsert = call.body() as List<Contacto>
                contactsToInsert.forEach {
                    db.ContactDAO().insert(Contacto(it.phone, it.name, it.surname, it.email, it.birthDate))
                }
            }

            var dbItems = db.ContactDAO().loadAllContacts()
            Log.i("cont", dbItems.toString())
            items.addAll(dbItems)
            itemSearch.addAll(dbItems)

                MainScope().launch {
                    //itemSearch = items.toMutableList()
                    rvItems.adapter?.notifyDataSetChanged()
                }

        }
        addButton.setOnClickListener(){
            val intent = Intent(this, Form::class.java).apply {

            }
            startActivity(intent)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        val searchView = menu?.findItem(R.id.item_search)?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return true
    }

    fun searchContacts(query: String?) {
        itemSearch.clear()
        for (contact in items){
            if (contact.name!!.contains(query!!, true)){
                itemSearch.add(contact)
            }
        }
        rvItems.adapter?.notifyDataSetChanged()
    }
    override fun onQueryTextSubmit(p0: String?): Boolean {
        searchContacts(p0)
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        searchContacts(p0)
        return false
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/marcoshita/exercises/")
            .addConverterFactory(GsonConverterFactory.create()) .build()
    }



}