package com.example.kotlin_practice2.mvvm_practice.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofilt by lazy {
        Retrofit.Builder()
            .baseUrl(Url.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api by lazy {
        retrofilt.create(jsonApi::class.java)
    }
}