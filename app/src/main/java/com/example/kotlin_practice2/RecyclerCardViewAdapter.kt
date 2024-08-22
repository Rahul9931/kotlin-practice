package com.example.kotlin_practice2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practice2.databinding.RecyclerviewCardBinding

class RecyclerCardViewAdapter(var context:Context, var dataList: ArrayList<card_model>): RecyclerView.Adapter<RecyclerCardViewAdapter.MyViewhHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewhHolder {
        var binding=RecyclerviewCardBinding.inflate(android.view.LayoutInflater.from(context), parent, false)
        return MyViewhHolder(binding)
        //return MyViewhHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_card, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewhHolder, position: Int) {
        holder.binding.img.setImageResource(dataList[position].img)
        holder.binding.txtName.text = dataList[position].name
        holder.binding.txtNo.text = dataList[position].number
        holder.itemView.setOnClickListener{
            Toast.makeText(context, dataList[position].name, Toast.LENGTH_LONG).show()
        }
        /*holder.img.setImageResource(dataList[position].img)
        holder.name.text = dataList[position].name
        holder.number.text = dataList[position].number*/
    }
    class MyViewhHolder(var binding: RecyclerviewCardBinding) : RecyclerView.ViewHolder(binding.root)
    /*class MyViewhHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val img = itemView.findViewById<ImageView>(R.id.img)
        val name = itemView.findViewById<TextView>(R.id.txt_name)
        val number = itemView.findViewById<TextView>(R.id.txt_no)
    }*/
}