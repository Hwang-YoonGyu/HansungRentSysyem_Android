package com.example.hansungrentsystem_android

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewBtn = findViewById<Button>(R.id.viewBtn)

            viewBtn.setOnClickListener {
                val intent = Intent(this, AskActivity::class.java)
                startActivity(intent)
            }
        }


}