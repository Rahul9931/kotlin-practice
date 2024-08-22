package com.example.kotlin_practice2.mvvm_practice.repository

import com.example.kotlin_practice2.mvvm_practice.network.RetrofitBuilder

class JsonRepository() {

    suspend fun getUserData() = RetrofitBuilder.api.getPost()
}