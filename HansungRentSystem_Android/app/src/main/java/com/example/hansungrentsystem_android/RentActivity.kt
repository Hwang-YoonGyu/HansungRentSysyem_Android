package com.example.hansungrentsystem_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
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
    var brand : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent)

    }
    fun queryJson()  {
        thread(start = true) {
            try {
                var urlText =
                    "http://223.194.158.173:8080/API/show?brand=" + brand

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
                    System.out.println(content.toString());


                    val json = JSONObject(content.toString())
                    val data = json.getJSONArray("Data")

                    val obj = data.getJSONObject(0)

                    val s = obj["code"].toString()



                }

            } catch (e: Exception) {
                System.out.println("리스트 json화 실패");
                System.out.println(e.toString());
            }

        }
    }
}