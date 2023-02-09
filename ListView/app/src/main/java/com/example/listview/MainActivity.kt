package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mobileArray = arrayOf(
            "Android", "IPhone", "WindowsMobile", "Blackberry",
            "WebOS", "Ubuntu", "Windows7", "Max OS X"
        )

        val adapter: ArrayAdapter<*> = ArrayAdapter(
            this,
            R.layout.activity_listview, mobileArray
        )

        val listView: ListView = findViewById(R.id.mobile_list)
        listView.adapter = adapter
    }
}

