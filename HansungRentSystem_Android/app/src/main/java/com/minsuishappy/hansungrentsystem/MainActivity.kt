package com.minsuishappy.hansungrentsystem

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.BufferedReader
import java.io.File
import java.io.FileWriter
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var user = User.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread(start = true) {
            try {
                var urlText = "http://13.125.253.41:8080/API/fcm/set?userId=" + User.getInstance(this).userId + "&token=" + User.getInstance(this).token + "&password=" + User.getInstance(this).password

                val url = URL(urlText)
                val netConn = url.openConnection() as HttpURLConnection

                if (netConn.responseCode == HttpURLConnection.HTTP_OK) {
                    val streamReader = InputStreamReader(netConn.inputStream)
                    val buffered = BufferedReader(streamReader)

                    val content = java.lang.StringBuilder()
                    while (true) {
                        val line = buffered.readLine() ?: break
                        content.append(line)
                    }
                    buffered.close()
                    netConn.disconnect()
                    System.out.println(content.toString());
                }

            } catch (e: Exception) {
                this.runOnUiThread {
                    System.out.println("오류 : " + e.toString());
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("").setMessage("API 서버 오류로 토큰을 전송하지 못했습니다.")
                        .setPositiveButton("확인", { _: DialogInterface, i: Int ->
                        })
                    val alertDialog: AlertDialog = builder.create()
                    alertDialog.show()
                }

            }
        }



        val viewBtn = findViewById<Button>(R.id.viewBtn)
        val logBtn = findViewById<Button>(R.id.logBtn)
        val noticeBtn = findViewById<Button>(R.id.noticeBtn)
        val logout = findViewById<TextView>(R.id.logout)
        val notelistBtn = findViewById<Button>(R.id.notelistBtn)
        var userInfo = findViewById<TextView>(R.id.userInfo)
        userInfo.text = user.userId + " " +user.userName
        viewBtn.setOnClickListener {
            val intent = Intent(this, AskActivity::class.java)
            startActivity(intent)
        }
        noticeBtn.setOnClickListener {
            val intent = Intent(this, NoticeActivity::class.java)
            startActivity(intent)
        }
        notelistBtn.setOnClickListener{
            val intent =Intent(this, DataActivity::class.java)
            startActivity(intent)
        }

        logBtn.setOnClickListener {
            thread(start = true) {
                try {
                    var urlText =
                        "http://13.125.253.41:8080/API/showLog?userId="+user.userId

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

                        val list = ArrayList<Log>()

                        for (i : Int in 0..data.length()-1) {
                            val obj = data.getJSONObject(i)
                            var temp = Log()
                            temp.setData(
                                userId = obj["userId"].toString(),
                                code = obj["code"].toString(),
                                rentDate = obj["rentDate"].toString(),
                                returnDate = obj["returnDate"].toString()
                            )
                            list.add(temp)
                        }
                        val intent = Intent(this, LogActivity::class.java)
                        intent.putExtra("list", list)
                        startActivity(intent)
                    }
                } catch (e: Exception) {
                    this.runOnUiThread {
                        System.out.println("오류 : "+e.toString());
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("").setMessage("API서버 오류입니다. 잠시 후에 다시 시도해 주세요.").setPositiveButton("확인", { _: DialogInterface, i:Int ->
                        })
                        val alertDialog: AlertDialog = builder.create()
                        alertDialog.show()
                    }
                }
            }
        }
        logout.setOnClickListener{
            onBackPressed()
        }
    }
}