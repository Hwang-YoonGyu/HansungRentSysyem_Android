package com.example.hansungrentsystem_android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rent.*
import kotlin.concurrent.thread

class LogActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)
        var list = intent.getSerializableExtra("list") as ArrayList<Log>

        var adapter = LogAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adapter

        val back = findViewById<TextView>(R.id.textView2)
        back.setOnClickListener {
            onBackPressed()
        }
    }
}