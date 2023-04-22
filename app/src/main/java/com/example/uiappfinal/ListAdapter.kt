package com.example.uiappfinal

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat.recreate
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.launch

class ListAdapter(val items:MutableList<Contacto>, val context: Context, val activity: Activity): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]
        //val item2 = itemsSearch[position]
        holder.tvItem.text = item.name
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "contacts.db"
        ).allowMainThreadQueries().build()

        holder.tvItem.setOnClickListener(){
            val intent = Intent(context, Detail::class.java).apply {
                putExtra("PHONE", item.phone)
                putExtra("NAME", item.name)
                putExtra("SURNAME", item.surname)
                putExtra("EMAIL", item.email)
                putExtra("BIRTHDATE", item.birthDate)
            }
            context.startActivity(intent)
        }

        holder.delBtn.setOnClickListener(){
            GlobalScope.launch {

                MainScope().launch {
                    val v = LayoutInflater.from(context).inflate(R.layout.confirm_delete, null)
                    AlertDialog.Builder(context).setView(v).setPositiveButton("Ok"){
                            dialog,_->
                        db.ContactDAO().delete(item)
                        items.removeAt(position)
                        //itemsSearch.removeAt(position)
                        notifyDataSetChanged()
                        Toast.makeText(context, "Contact deleted succesfully", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                        //recreate(activity)
                    }.setNegativeButton("Cancel"){
                            dialog,_->
                        dialog.dismiss()
                    }.create().show()
                    notifyDataSetChanged()
                }

            }
            //notifyDataSetChanged()

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvItem = view.findViewById<TextView>(R.id.tv_item)
        val delBtn = view.findViewById<Button>(R.id.itemDelButton)
    }

}