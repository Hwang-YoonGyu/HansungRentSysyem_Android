package com.minsuishappy.hansungrentsystem

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class NoticeActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_noti)

            val back = findViewById<TextView>(R.id.Noti_backBtn)
            back.setOnClickListener {
                onBackPressed()
            }
        }
}


