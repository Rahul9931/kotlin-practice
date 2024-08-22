package com.example.kotlin_practice2.mvvm_practice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_practice2.mvvm_practice.repository.JsonRepository

class UserViewModelFactory(private val repository: JsonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}