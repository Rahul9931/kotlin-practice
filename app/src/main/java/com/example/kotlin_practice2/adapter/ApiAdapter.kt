package com.example.kotlin_practice2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practice2.databinding.ApiItemCardBinding
import com.example.kotlin_practice2.model.MyUserItem
import com.example.kotlin_practice2.model.Users

class ApiAdapter(val context:Context, val usersList: List<Users>):
    RecyclerView.Adapter<ApiAdapter.ApiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val binding = ApiItemCardBinding.inflate(LayoutInflater.from(context),parent,false)
        return ApiViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ApiViewHolder(val binding:ApiItemCardBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val currentUser = usersList[position]
            binding.txtId.text = currentUser.id.toString()
            binding.txtNameApi.text = currentUser.name
            binding.txtUsername.text = currentUser.username
            binding.txtEmailApi.text = currentUser.email_user
        }

    }
}