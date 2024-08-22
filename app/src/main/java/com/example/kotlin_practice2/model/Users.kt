package com.example.kotlin_practice2.model

import com.google.gson.annotations.SerializedName

class Users(
    val id:Int,
    val name:String,
    @SerializedName("email")
    val email_user:String,
    val username:String
)