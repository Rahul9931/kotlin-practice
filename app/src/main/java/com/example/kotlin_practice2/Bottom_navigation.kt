package com.example.kotlin_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation

import androidx.navigation.ui.setupWithNavController
import com.example.kotlin_practice2.databinding.ActivityBottomNavigationBinding

class Bottom_navigation : AppCompatActivity() {
   private lateinit var binding: ActivityBottomNavigationBinding
   private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.fragmentcv)
        binding.bnview.setupWithNavController(navController)

    }
}