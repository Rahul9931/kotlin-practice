package com.example.kotlin_practice2.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Airmode:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val state:Boolean = intent?.getBooleanExtra("state",false)?:return
        if (state){
            Toast.makeText(context, "I AM ON", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(context, "I AM OFF", Toast.LENGTH_LONG).show()
        }
    }
}