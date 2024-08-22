package com.example.kotlin_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.kotlin_practice2.databinding.ActivityDrawerNavigationBinding
import com.example.kotlin_practice2.fragments.Chat_fragment
import com.example.kotlin_practice2.fragments.Home_fragment
import com.example.kotlin_practice2.fragments.Profile_fragment
import com.example.kotlin_practice2.fragments.messanger_fragment
import com.google.android.material.navigation.NavigationView

class Drawer_Navigation : AppCompatActivity() {
    lateinit var binding: ActivityDrawerNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerlayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer)
        binding.drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        if(savedInstanceState == null){
            loadFragment(Home_fragment())
        }
        binding.navigationview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(Home_fragment())
                    true
                }
                R.id.chat -> {
                    loadFragment(Chat_fragment())
                    true
                }
                R.id.messenger -> {
                    loadFragment(messanger_fragment())
                    true
                }
                R.id.profile -> {
                    loadFragment(Profile_fragment())
                    true
                }
                else ->{
                   onBackPressed()
                    true
                }
                }
            binding.drawerlayout.closeDrawer(GravityCompat.START)
            true
            }
        }
    override fun onBackPressed() {
        if(binding.drawerlayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerlayout.closeDrawer(GravityCompat.START)
        }
        else{
            onBackPressedDispatcher.onBackPressed()
        }
    }
    fun loadFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.replace(R.id.frame, fragment)
        tr.commit()
    }
    }