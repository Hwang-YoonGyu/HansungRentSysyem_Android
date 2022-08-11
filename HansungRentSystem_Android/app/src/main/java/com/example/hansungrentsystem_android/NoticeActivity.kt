package com.example.hansungrentsystem_android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class NoticeActivity : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_notice)


            val back = findViewById<TextView>(R.id.Notice_backBtn)
            back.setOnClickListener {
                onBackPressed()
            }



        }


}


