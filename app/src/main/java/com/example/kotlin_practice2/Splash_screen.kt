package com.example.kotlin_practice2

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import kotlin.concurrent.thread


class Splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //************** Simple Splash screen Start *********************
        /*Handler(Looper.getMainLooper()).postDelayed(5000){
            startActivity(Intent(this,custom_cardview::class.java))*/
        //************** Simple Splash Screen End **********************
        splash()
        }

    private fun splash() {
        loadDataWithSplash().execute()
    }
    private open inner class loadDataWithSplash:AsyncTask<String?, Void?, String?>(){
        override fun doInBackground(vararg params: String?): String? {
            Thread.sleep(5000)
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            startActivity(Intent(this@Splash_screen, custom_cardview::class.java))
        }

    }
}
