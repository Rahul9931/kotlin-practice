package com.example.kotlin_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class custom_toolbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.opt_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.opt_new -> Toast.makeText(this,"New option press", Toast.LENGTH_LONG).show()
            R.id.opt_open -> Toast.makeText(this,"Open option press", Toast.LENGTH_LONG).show()
            R.id.opt_save -> Toast.makeText(this,"Save option press", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}