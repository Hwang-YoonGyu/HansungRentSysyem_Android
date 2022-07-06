package com.example.hansungrentsystem_android

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        //var obj = intent.getSerializableExtra("obj") as ObjectLaptop
        //var obj = intent.getStringExtra("obj")
        val user = User.getInstance(this)
        val name = findViewById<TextView>(R.id.detail_name)
        val code = findViewById<TextView>(R.id.detail_code)
        val rentDate = findViewById<TextView>(R.id.detail_rentDate)
        val returnDate = findViewById<TextView>(R.id.detail_returnDate)
        val userId = findViewById<TextView>(R.id.detail_userId)
        val userName = findViewById<TextView>(R.id.detail_userName)
        val rentBtn = findViewById<Button>(R.id.detail_rentBtn)
        val cancelBtn = findViewById<Button>(R.id.detail_cancelBtn)


//        name.text = obj.name
//        code.text = obj.code

        rentDate.text = LocalDate.now().toString()
        returnDate.text = LocalDate.now().plusDays(30).toString()
        userId.text = user.userId
        userName.text = user.userName

        rentBtn.setOnClickListener {

        }
        cancelBtn.setOnClickListener {
            onBackPressed()
        }



    }
}