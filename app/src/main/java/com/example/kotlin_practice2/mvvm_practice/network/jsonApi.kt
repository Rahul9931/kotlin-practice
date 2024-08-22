package com.example.kotlin_practice2.mvvm_practice.network

import com.example.kotlin_practice2.model.MyUserItem
import retrofit2.http.GET

interface jsonApi {

    @GET("posts")
    suspend fun getPost():List<MyUserItem>
}