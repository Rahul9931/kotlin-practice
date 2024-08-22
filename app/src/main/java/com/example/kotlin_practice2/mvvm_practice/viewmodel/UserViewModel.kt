package com.example.kotlin_practice2.mvvm_practice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_practice2.model.MyUserItem
import com.example.kotlin_practice2.mvvm_practice.repository.JsonRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: JsonRepository) : ViewModel() {

    val mutableLiveData:MutableLiveData<List<MyUserItem>> = MutableLiveData()

    fun getUserData(){
        viewModelScope.launch {
            val response = repository.getUserData()
            mutableLiveData.value = response
        }
    }
}