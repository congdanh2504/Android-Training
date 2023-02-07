package com.example.services

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class MyForegroundService: Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val data = intent!!.getStringExtra("data")
        sendNotification(data!!)
        return START_NOT_STICKY
    }

    private fun sendNotification(data: String) {
        try {
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val notification  = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                .setContentTitle("Title")
                .setContentText(data)
                .setContentIntent(pendingIntent)
                .build()

            startForeground(1, notification)
        } catch (e: java.lang.Exception) {
            Log.d("Service", "Error: ${e.message}")
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}