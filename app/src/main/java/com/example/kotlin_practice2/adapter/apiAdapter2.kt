package com.example.kotlin_practice2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practice2.databinding.ApiCardBinding
import com.example.kotlin_practice2.model.MyUserItem

class apiAdapter2(val context:Context, var arrayList: ArrayList<MyUserItem>):
    RecyclerView.Adapter<apiAdapter2.apiAdaperViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): apiAdapter2.apiAdaperViewHolder {
        val binding = ApiCardBinding.inflate(LayoutInflater.from(context),parent,false)
        return apiAdaperViewHolder(binding)
    }

    override fun onBindViewHolder(holder: apiAdapter2.apiAdaperViewHolder, position: Int) {
        holder.binding.apply {
            txtId2.text = arrayList[position].id.toString()
            txtDescription.text = arrayList[position].title
        }
    }

    override fun getItemCount() = arrayList.size

    inner class apiAdaperViewHolder(val binding:ApiCardBinding):RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(userList: ArrayList<MyUserItem>){
        this.arrayList = userList
        notifyDataSetChanged()
    }
}