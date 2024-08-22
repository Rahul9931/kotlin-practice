package com.example.kotlin_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_practice2.adapter.ApiAdapter
import com.example.kotlin_practice2.api_interface.JsonPlaceHolder
import com.example.kotlin_practice2.databinding.ActivityApiCallingBinding
import com.example.kotlin_practice2.model.UserPost
import com.example.kotlin_practice2.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.StringBuilder

class Api_Calling_Activity : AppCompatActivity() {
    private val binding: ActivityApiCallingBinding by lazy {
        ActivityApiCallingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Retrofit Builder
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        // Create Interface Object
        // Get Method
       /* val jsonapi = retrofit.create(JsonPlaceHolder::class.java)
        val call = jsonapi.getUsers()
        call.enqueue(object : Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                val responseBody = response.body()!!

                val myadapter = ApiAdapter(this@Api_Calling_Activity, responseBody)
                binding.rvApi.layoutManager = LinearLayoutManager(this@Api_Calling_Activity)
                binding.rvApi.adapter = myadapter
                Toast.makeText(this@Api_Calling_Activity, "success", Toast.LENGTH_SHORT).show()
                Log.d("success","${responseBody}")
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Toast.makeText(this@Api_Calling_Activity, "fail", Toast.LENGTH_SHORT).show()
                Log.d("fail","${t}")
            }


        })*/

        // Post Method
        // Create Interface Object
        /*val jsonPlaceHolder = retrofit.create(JsonPlaceHolder::class.java)
        val userPost=UserPost(1,101,"Rahul Saini","Super")

        val call = jsonPlaceHolder.sendUserData(userPost)
        call.enqueue(object : Callback<UserPost>{
            override fun onResponse(call: Call<UserPost>, response: Response<UserPost>) {
                val responsedata = response.body()
                binding.txtMsg.text = "${responsedata?.userId}\n${responsedata?.id}\n${responsedata?.title}\n${responsedata?.body}\n"
                Log.d("postmsg1","${response.code()}")
                Log.d("postmsg2","${response.body()}")
            }

            override fun onFailure(call: Call<UserPost>, t: Throwable) {
                binding.txtMsg.text = t.message.toString()
                Log.d("postmsg3","${t.message}")
            }

        })*/

        // Put Method
        // Update User Data but if data is not exist in particular id then it create new data
        /*val jsonPlaceHolder = retrofit.create(JsonPlaceHolder::class.java)
        val userPost = UserPost(101,1,"shivam","kumar")
        val call = jsonPlaceHolder.put(5,userPost)
        call.enqueue(object : Callback<UserPost>{
            override fun onResponse(call: Call<UserPost>, response: Response<UserPost>) {
                val responsedata = response.body()
                binding.txtMsg.text = "${responsedata?.userId}\n${responsedata?.id}\n${responsedata?.title}\n${responsedata?.body}\n"
                Log.d("postmsg1","${response.code()}")
                Log.d("postmsg2","${response.body()}")
            }

            override fun onFailure(call: Call<UserPost>, t: Throwable) {
                binding.txtMsg.text = t.message.toString()
                Log.d("postmsg3","${t.message}")
            }

        })*/

        // Patch Method
        // Patch is used to update data but it is also capable to update single data
        // and if some data is null then it does not change that data
        val jsonPlaceHolder = retrofit.create(JsonPlaceHolder::class.java)
        val userPost = UserPost(5,101,"Vegita","Saiyan")
        val call = jsonPlaceHolder.patch(5,userPost)
        call.enqueue(object : Callback<UserPost>{
            override fun onResponse(call: Call<UserPost>, response: Response<UserPost>) {
                val responsedata = response.body()
                binding.txtMsg.text = "${responsedata?.userId}\n${responsedata?.id}\n${responsedata?.title}\n${responsedata?.body}\n"
                Log.d("postmsg1","${response.code()}")
                Log.d("postmsg2","${response.body()}")
            }

            override fun onFailure(call: Call<UserPost>, t: Throwable) {
                binding.txtMsg.text = t.message.toString()
                Log.d("postmsg3","${t.message}")
            }

        })

        // Delete user data
        /*val jsonPlaceHolder = retrofit.create(JsonPlaceHolder::class.java)
        val call = jsonPlaceHolder.delete(5)
        call.enqueue(object :Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                Log.d("postmsg1","${response.code()}")
                Log.d("postmsg2","${response.body()}")
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d("postmsg3","${t.message}")
            }

        })*/
    }
}