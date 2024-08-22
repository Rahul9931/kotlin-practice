package com.example.kotlin_practice2.mvvm_practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.ActivityMvvmWithCounterBinding
import com.example.kotlin_practice2.mvvm_practice.viewmodel.CounterUpdateViewModel

class MVVM_with_counter : AppCompatActivity() {
    private val binding:ActivityMvvmWithCounterBinding by lazy {
        ActivityMvvmWithCounterBinding.inflate(layoutInflater)
    }
    private lateinit var mvvmIntance:CounterUpdateViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mvvmIntance = ViewModelProvider(this).get(CounterUpdateViewModel::class.java)
        setText()
        binding.btnCounter.setOnClickListener {
            mvvmIntance.increment()
            setText()
        }
    }

    private fun setText() {
        binding.txtCounter.text = mvvmIntance.counter.toString()
    }
}