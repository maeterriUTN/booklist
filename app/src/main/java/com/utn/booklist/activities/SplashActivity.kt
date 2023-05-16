package com.utn.booklist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.utn.booklist.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long = 3000 // 3 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(

            {
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
                finish()
            }
            , SPLASH_TIME_OUT)
    }
}