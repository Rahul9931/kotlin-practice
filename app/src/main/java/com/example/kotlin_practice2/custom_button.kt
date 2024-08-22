package com.example.kotlin_practice2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.example.kotlin_practice2.databinding.ActivityCustomButtonBinding

class custom_button : AppCompatActivity() {
    private val binding:ActivityCustomButtonBinding by lazy {
        ActivityCustomButtonBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.image.setOnClickListener {
            val inext = Intent(this,custom_cardview::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair(binding.image,"img"))
            startActivity(inext, options.toBundle())
        }
    }
}