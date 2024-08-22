package com.example.kotlin_practice2

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Simple_and_Custom_Alert_Dialog : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_and_custom_alert_dialog)
        // ************** Simple Alert Dialog  *****************
        /*val btn_simple = findViewById<Button>(R.id.btn_simple)
        btn_simple.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Delete File")
            dialog.setMessage("File successfully deleted")
            dialog.setIcon(R.drawable.baseline_delete_24)

            dialog.setPositiveButton("Yes"){dialogInterface,which ->
                Toast.makeText(this, "Clicked Yes", Toast.LENGTH_LONG).show()
            }

            dialog.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(this, "Clicked No", Toast.LENGTH_LONG).show()
            }

            dialog.setNeutralButton("Cancel"){dialogInterface, which ->
                Toast.makeText(this, "Clicked Cancel", Toast.LENGTH_LONG).show()
            }
            val alertDialog:AlertDialog = dialog.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }*/
        // ************** END Simple Alert Dialog  *****************
        val btn_custom_dialog = findViewById<Button>(R.id.btn_custom)

        btn_custom_dialog.setOnClickListener {
            val customDialog = Dialog(this)
            customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            customDialog.setContentView(R.layout.custom_dialog)
            customDialog.setCancelable(false)
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.BLUE))
            val btn_yes = customDialog.findViewById<Button>(R.id.btn_yes)
            val btn_no = customDialog.findViewById<Button>(R.id.btn_no)
            btn_no.setOnClickListener {
                Toast.makeText(this, "Clicked No", Toast.LENGTH_LONG).show()
                customDialog.dismiss()
            }
            btn_yes.setOnClickListener {
                Toast.makeText(this, "Clicked Yes", Toast.LENGTH_LONG).show()
                customDialog.dismiss()
            }
            customDialog.show()
        }


        }
    }