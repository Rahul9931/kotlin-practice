package com.example.kotlin_practice2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.example.kotlin_practice2.databinding.ActivitySharedPreferencesBinding

class Shared_Preferences_Activity : AppCompatActivity() {
    private lateinit var listener:SharedPreferences.OnSharedPreferenceChangeListener
    private val binding:ActivitySharedPreferencesBinding by lazy {
        ActivitySharedPreferencesBinding.inflate(layoutInflater)
    }
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val manager = PreferenceManager.getDefaultSharedPreferences(this)
        listener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            if (key.equals("changeColor")){
                if (manager.getBoolean("changeColor",false)==true)
                    binding.container.setBackgroundColor(R.color.lightblue)
                else
                    binding.container.setBackgroundColor(R.color.darkGreen)
            }
        }
        manager.registerOnSharedPreferenceChangeListener(listener)

        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.edtEmail.setText(editor.getString("email",null))
        binding.edtPassword.setText(editor.getString("password",null))

        binding.btnLogin.setOnClickListener {
            val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            editor.putString("email",email)
            editor.putString("password",password)
            editor.apply()
            startActivity(Intent(this,Shared_Preference2::class.java))
        }

        binding.setting.setOnClickListener {
            startActivity(Intent(this,SettingsActivity::class.java))
        }
    }
}