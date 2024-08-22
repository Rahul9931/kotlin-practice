package com.example.kotlin_practice2.api_interface

import com.example.kotlin_practice2.model.UserPost
import com.example.kotlin_practice2.model.Users
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface JsonPlaceHolder {

    // Get users data
    @GET("users")
    fun getUsers():Call<List<Users>>

    // Send user data
    @POST("posts")
    fun sendUserData(
        @Body userPost: UserPost
    ):Call<UserPost>

    // Delete user data
    @DELETE("posts/{id}")
    fun delete(
        @Path("id") id:Int
    ):Call<Unit>

    // Update using Put method
    // Update User Data but if data is not exist in particular id then it create new data
    @PUT("posts/{id}")
    fun put(
        @Path("id") id:Int,
        @Body userPost: UserPost
    ):Call<UserPost>

    // Update using Patch method
    // Patch is used to update data but it is also capable to update single data
    // and if some data is null then it does not change that data
    @PATCH("posts/{id}")
    fun patch(
        @Path("id") id:Int,
        @Body userPost: UserPost
    ):Call<UserPost>
}