package com.example.kotlin_practice2.navigation_practice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.ActivityBottomBarBinding

class BottomBar : AppCompatActivity() {
    private val binding :ActivityBottomBarBinding by lazy {
        ActivityBottomBarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.myhome -> {
                    status("my home")
                    true
                }

                R.id.mymessage -> {
                    status("my message")
                    true
                }

                else -> {
                    status("my profile")
                    true
                }
            }
        }
    }

    private fun status(s: String) {
        Toast.makeText(this, "$s", Toast.LENGTH_LONG).show()

    }
}