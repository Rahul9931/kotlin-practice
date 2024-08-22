package com.example.kotlin_practice2.local_database_practice.room_practice

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val phone:String,
    val isActive:Int
) {
}