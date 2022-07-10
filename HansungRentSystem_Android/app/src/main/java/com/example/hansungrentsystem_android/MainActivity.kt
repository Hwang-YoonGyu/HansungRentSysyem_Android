package com.example.hansungrentsystem_android

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var user = User.getInstance(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewBtn = findViewById<Button>(R.id.viewBtn)
        val terminateBtn = findViewById<Button>(R.id.terminateBtn)
        var userInfo = findViewById<TextView>(R.id.userInfo)
        userInfo.text = user.userId + " " +user.userName
            viewBtn.setOnClickListener {
                val intent = Intent(this, AskActivity::class.java)
                startActivity(intent)
            }
            terminateBtn.setOnClickListener{
                onBackPressed()
            }

        }


}