package com.example.kotlin_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_practice2.databinding.ActivityTabLayoutBinding

class Tab_layout : AppCompatActivity() {
    lateinit var binding: ActivityTabLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vpAdapter = ViewPagerAdapter(supportFragmentManager)
        binding.viewpager.adapter = vpAdapter
        binding.tab.setupWithViewPager(binding.viewpager)
    }
}