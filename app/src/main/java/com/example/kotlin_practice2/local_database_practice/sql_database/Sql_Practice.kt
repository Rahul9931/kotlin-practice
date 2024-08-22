package com.example.kotlin_practice2.local_database_practice.sql_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.ActivitySqlPracticeBinding

class Sql_Practice : AppCompatActivity() {
    private val binding:ActivitySqlPracticeBinding by lazy {
        ActivitySqlPracticeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var db = DBHelper(this)
        binding.btnInsert.setOnClickListener {
            val title = binding.edtTitle.text.toString()
            val content = binding.edtContent.text.toString()
            val note = Note(1,title, content)
            db.insertNote(note)
            Toast.makeText(this, "Note inserted", Toast.LENGTH_SHORT).show()
        }
        binding.btnFetch.setOnClickListener {
            Log.d("fetchList","${db.getAllNote()}")
        }
        binding.btnUpdate.setOnClickListener {
            val note = Note(3,"Goku","Super Saiyan")
            db.updateNote(note)
        }
        binding.btnDelete.setOnClickListener {
            db.deleteNote(3)
        }
    }
}