package com.example.kotlin_practice2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practice2.databinding.ActivityRecyclerCardViewBinding

class RecyclerCardView : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerCardViewBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val myadapter = RecyclerCardViewAdapter(this,dataContact.getData())
        binding.recyclerView.adapter = myadapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}