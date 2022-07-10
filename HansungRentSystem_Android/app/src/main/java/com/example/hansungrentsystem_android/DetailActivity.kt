package com.example.hansungrentsystem_android

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
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
import java.time.LocalDate
import kotlin.concurrent.thread

class DetailActivity : AppCompatActivity() {
    private val rentActivity = RentActivity.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        var obj = intent.getSerializableExtra("obj") as ObjectLaptop
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


        name.text = obj.name
        code.text = obj.code

        rentDate.text = LocalDate.now().toString()
        returnDate.text = LocalDate.now().plusDays(30).toString()
        userId.text = user.userId
        userName.text = user.userName

        rentBtn.setOnClickListener {
//            thread(start = true) {
//                try {
//                    var urlText =
//                        "http://10.0.2.2:8080/API/Rent?code="+obj.code+
//                                "&userId="+user.userId+
//                                "&userPhone="+user.userPhone+
//                                "&rentDate="+rentDate.text+
//                                "&returnDate="+returnDate.text
//
//                    val url = URL(urlText)
//                    val netConn = url.openConnection() as HttpURLConnection
//
//                    if (netConn.responseCode == HttpURLConnection.HTTP_OK) {
//                        val streamReader = InputStreamReader(netConn.inputStream)
//                        val buffered = BufferedReader(streamReader)
//
//                        val content = StringBuilder()
//                        while (true) {
//                            val line = buffered.readLine() ?: break
//                            content.append(line)
//                        }
//                        buffered.close()
//                        netConn.disconnect()
//
//                        val json = JSONObject(content.toString())
//                        val result =json["result"].toString()
//
//
//                        if (result.equals("1")) {
//
//                        }
//                        else if (result.equals("0")) {
//
//                        }
//
//
//                    }
//
//                } catch (e: Exception) {
//                    System.out.println("오류");
//                    System.out.println(e.toString());
//                }
//
//            }
            rentActivity?.changeMethod(obj.code)
            onBackPressed()


        }
        cancelBtn.setOnClickListener {
            onBackPressed()
        }



    }
}