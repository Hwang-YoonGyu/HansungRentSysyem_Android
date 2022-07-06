package com.example.hansungrentsystem_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread


class AskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask)

        val back = findViewById<TextView>(R.id.Ask_backBtn)
        back.setOnClickListener {
            onBackPressed()
        }

        val samsungBtn = findViewById<Button>(R.id.Ask_samsung)
        samsungBtn.setOnClickListener {
            queryJson("samsung")
        }

        val lgBtn = findViewById<Button>(R.id.Ask_lg)
        lgBtn.setOnClickListener {
            queryJson("lg")
        }

        val msiBtn = findViewById<Button>(R.id.Ask_msi)
        msiBtn.setOnClickListener {
            queryJson("msi")
        }

        val appleBtn = findViewById<Button>(R.id.Ask_apple)
        appleBtn.setOnClickListener {
            queryJson("apple")
        }
    }
    fun queryJson(brand : String)  {
        thread(start = true) {
            try {
                var urlText =
                    "http://10.0.2.2:8080/API/show?brand=" + brand

                val url = URL(urlText)
                val netConn = url.openConnection() as HttpURLConnection

                if (netConn.responseCode == HttpURLConnection.HTTP_OK) {
                    val streamReader = InputStreamReader(netConn.inputStream)
                    val buffered = BufferedReader(streamReader)

                    val content = StringBuilder()
                    while (true) {
                        val line = buffered.readLine() ?: break
                        content.append(line)
                    }
                    buffered.close()
                    netConn.disconnect()


                    val json = JSONObject(content.toString())
                    val data = json.getJSONArray("Data")

                    val obj = data.getJSONObject(0)


                    val s = obj["code"].toString()
                    System.out.println(s)


                }

            } catch (e: Exception) {
                System.out.println("리스트 json화 실패");
                System.out.println(e.toString());
            }

        }
    }
}
