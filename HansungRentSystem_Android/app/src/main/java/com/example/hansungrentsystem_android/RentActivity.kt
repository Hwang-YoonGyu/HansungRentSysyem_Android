package com.example.hansungrentsystem_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rent.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class RentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent)

        val list = ArrayList<MainData>()
        list.add(MainData("자바", "010-0000-0000"))
        list.add(MainData("안드로이드", "011-1111-1111"))
        list.add(MainData("코틀린", "016-2222-2222"))
        list.add(MainData("리사이클러뷰", "017-3333-3333"))
        list.add(MainData("HTML", "010-4444-4444"))
        list.add(MainData("CSS", "011-5555-5555"))
        list.add(MainData("JavaScript", "012-6666-6666"))
        list.add(MainData("PHP", "010-7777-7777"))
        list.add(MainData("변수", "010-8888-8888"))
        list.add(MainData("스틱코드", "010-9999-9999"))
        list.add(MainData("마스크", "010-1234-1234"))
        list.add(MainData("자바", "010-0000-0000"))
        list.add(MainData("안드로이드", "011-1111-1111"))
        list.add(MainData("코틀린", "016-2222-2222"))
        list.add(MainData("리사이클러뷰", "017-3333-3333"))
        list.add(MainData("HTML", "010-4444-4444"))
        list.add(MainData("CSS", "011-5555-5555"))
        list.add(MainData("JavaScript", "012-6666-6666"))
        list.add(MainData("PHP", "010-7777-7777"))
        list.add(MainData("변수", "010-8888-8888"))
        list.add(MainData("스틱코드", "010-9999-9999"))
        list.add(MainData("마스크", "010-1234-1234"))

        val adapter = MainAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adapter
    }
}