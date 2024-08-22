package com.example.kotlin_practice2.mvvm_practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.adapter.ApiAdapter
import com.example.kotlin_practice2.adapter.apiAdapter2
import com.example.kotlin_practice2.databinding.ActivityShowUserDataBinding
import com.example.kotlin_practice2.model.MyUserItem
import com.example.kotlin_practice2.mvvm_practice.repository.JsonRepository
import com.example.kotlin_practice2.mvvm_practice.viewmodel.UserViewModel
import com.example.kotlin_practice2.mvvm_practice.viewmodel.UserViewModelFactory

class ShowUserData : AppCompatActivity() {
    private val binding:ActivityShowUserDataBinding by lazy {
        ActivityShowUserDataBinding.inflate(layoutInflater)
    }
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Set Adapter
        var userAdapter = apiAdapter2(this, ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ShowUserData)
            adapter = userAdapter
        }
        // Set View Model
        val repository = JsonRepository()
        val viewModelFactory = UserViewModelFactory(repository)
        userViewModel = ViewModelProvider(this,viewModelFactory)[UserViewModel::class.java]
        userViewModel.getUserData()
        userViewModel.mutableLiveData.observe(this, Observer {
            userAdapter.setData(it as ArrayList<MyUserItem>)

        })

    }
}