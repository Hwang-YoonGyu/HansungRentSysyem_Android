package com.minsuishappy.hansungrentsystem

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class listActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notebooklist)

        val back = findViewById<TextView>(R.id.list_backBtn)
        back.setOnClickListener {
            onBackPressed()
        }
    }
}