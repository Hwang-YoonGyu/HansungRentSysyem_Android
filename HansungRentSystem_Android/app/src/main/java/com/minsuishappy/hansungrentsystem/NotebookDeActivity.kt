package com.minsuishappy.hansungrentsystem

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rent.*

class NotebookDeActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notebookdetail)
        val data = intent.getSerializableExtra("obj") as Data

        val back = findViewById<TextView>(R.id.nbDetail_backBtn)
        back.setOnClickListener {
            onBackPressed()
        }
    }
}