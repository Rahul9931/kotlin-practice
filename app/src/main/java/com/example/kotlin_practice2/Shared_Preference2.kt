package com.example.kotlin_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_practice2.databinding.ActivitySharedPreference2Binding

class Shared_Preference2 : AppCompatActivity() {
    private val binding:ActivitySharedPreference2Binding by lazy{
        ActivitySharedPreference2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.showStatus.setText("Email = ${editor.getString("email",null)}"+"And Password = ${editor.getString("password",null)}")
    }
}