package com.example.kotlin_practice2.advance

import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.concurrent.thread

class Coroutine_Activity : AppCompatActivity() {
    private val binding:ActivityCoroutineBinding by lazy {
        ActivityCoroutineBinding.inflate(layoutInflater)
    }
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val animation = AnimationUtils.loadAnimation(this,R.anim.rotate_object)
        binding.txtTitle.startAnimation(animation)

        binding.btnGo.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                printFollowers()
            }
        }

        binding.btnInc.setOnClickListener {
             binding.txtCount.setText("${count++}")
        }
    }

    private suspend fun printFollowers() {
        var job = CoroutineScope(Dispatchers.IO).async {
            getFBFollowers()
        }
        Log.d("fb_follower",job.await().toString())
    }

    private suspend fun getFBFollowers(): Int {
        delay(1000)
        return 50
    }


}