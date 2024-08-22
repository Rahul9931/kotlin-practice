package com.example.kotlin_practice2.local_database_practice.room_practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.ActivityRoomBinding
import com.example.kotlin_practice2.databinding.ActivityRoomWithSingleTonBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Room_With_SingleTon : AppCompatActivity() {
    private val binding: ActivityRoomWithSingleTonBinding by lazy {
        ActivityRoomWithSingleTonBinding.inflate(layoutInflater)
    }
    private lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_room_with_single_ton)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        database = ContactDatabase.getDatabase(this)
        val database2 = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"Super2","343234543",1))
        }
    }
}