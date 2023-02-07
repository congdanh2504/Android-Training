package com.example.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.start.setOnClickListener {
            startService()
        }

        mainBinding.end.setOnClickListener {
            val intent = Intent(this, MyForegroundService::class.java)
            stopService(intent)
        }
    }

    private fun startService() {
        val intent = Intent(this, MyForegroundService::class.java)
        intent.putExtra("data", mainBinding.edittext.text)
        startService(intent)
    }
}