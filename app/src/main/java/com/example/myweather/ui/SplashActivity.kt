package com.example.myweather.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myweather.R
import java.util.*
import kotlin.concurrent.schedule

private const val TIMER=3000L

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer().schedule(TIMER){
            startToHomeActivity()
        }
    }

    fun startToHomeActivity(){
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}