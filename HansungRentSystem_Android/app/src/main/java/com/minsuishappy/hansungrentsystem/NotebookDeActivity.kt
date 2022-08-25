package com.minsuishappy.hansungrentsystem

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotebookDeActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notebookdetail)


        findViewById<TextView>(R.id.notebookName).text = intent.getStringExtra ("name")
        findViewById<TextView>(R.id.notebookCode).text = intent.getStringExtra ("code")
        when (intent.getStringExtra("name")) {
            "MacBook Pro" -> findViewById<ImageView>(R.id.notebookImg).setImageDrawable(getDrawable(R.drawable.macbookpro))
            "MacBook Air" -> findViewById<ImageView>(R.id.notebookImg).setImageDrawable(getDrawable(R.drawable.macbookair))
            "Odyssey" -> findViewById<ImageView>(R.id.notebookImg).setImageDrawable(getDrawable(R.drawable.odyssey))
            "Gram" -> findViewById<ImageView>(R.id.notebookImg).setImageDrawable(getDrawable(R.drawable.gram))
            "Sword" -> findViewById<ImageView>(R.id.notebookImg).setImageDrawable(getDrawable(R.drawable.sword))
        }

        val back = findViewById<TextView>(R.id.nbDetail_backBtn)
        back.setOnClickListener {
            onBackPressed()
        }
    }
}