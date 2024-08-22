package com.example.kotlin_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlin_practice2.databinding.ActivityPracticeFragmentBinding
import com.example.kotlin_practice2.fragments.Home_fragment
import com.example.kotlin_practice2.fragments.Profile_fragment

class Practice_fragment : AppCompatActivity() {
    val binding by lazy {
        ActivityPracticeFragmentBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnHome.setOnClickListener {
            loadFragment(Home_fragment())
        }

        binding.btnProfile.setOnClickListener {
            loadFragment(Profile_fragment())
        }


    }
    fun loadFragment(fragment:Fragment){
        var manager = supportFragmentManager
        var tr = manager.beginTransaction()
        tr.replace(R.id.frame, fragment)
        tr.commit()
    }
}