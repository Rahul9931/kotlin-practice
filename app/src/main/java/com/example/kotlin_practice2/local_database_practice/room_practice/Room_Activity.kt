package com.example.kotlin_practice2.local_database_practice.room_practice

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.ActivityRoomBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Room_Activity : AppCompatActivity() {
    private val binding:ActivityRoomBinding by lazy {
        ActivityRoomBinding.inflate(layoutInflater)
    }
    private lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDB").build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"Rahul3","9953838131"))
        }
         binding.btnGetdata.setOnClickListener {
             getContactData()
         }
        binding.btnUpdateData.setOnClickListener {
            updateData(Contact(1,"Goku","33334444422"))
        }
        binding.btnjDeleteData.setOnClickListener {
            deleteData(Contact(1,"Goku","33334444422"))
        }*/
    }

    private fun deleteData(contact: Contact) {
        GlobalScope.launch {
            database.contactDao().deleteContact(contact)
        }
    }

    private fun updateData(contact: Contact) {
        GlobalScope.launch {
            database.contactDao().updateContact(contact)
        }
    }

    private fun getContactData() {
        database.contactDao().getContact().observe(this, Observer {
            Log.d("Check_getData","${it}")
        })
    }


}