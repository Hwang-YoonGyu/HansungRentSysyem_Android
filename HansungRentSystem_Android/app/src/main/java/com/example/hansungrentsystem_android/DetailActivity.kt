package com.example.hansungrentsystem_android

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_detail)


        val obj = intent.getSerializableExtra("obj") as ObjectLaptop

        System.out.print(obj.code)
        System.out.print(obj.name)


    }
}