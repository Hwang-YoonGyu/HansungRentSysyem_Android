package com.example.hansungrentsystem_android

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
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

                    val list = ArrayList<ObjectLaptop>()

                    for (i : Int in 0..data.length()-1) {
                        val obj = data.getJSONObject(i)
                        var temp = ObjectLaptop()

                        if (obj["status"].toString()=="대여가능") {
                            temp.setData(
                                code = obj["code"].toString(),
                                name = obj["name"].toString(),
                                status = "대여",
                                userId = obj["userId"].toString(),
                                userPhone = obj["userPhone"].toString(),
                                rentDate = obj["rentDate"].toString(),
                                returnDate = obj["returnDate"].toString(),
                                enable = true

                            )
                            temp.color = Color.parseColor("#3378f7")
                            temp.textColor = Color.parseColor("#ffffff")

                        }
                        else {
                            temp.setData(
                                code = obj["code"].toString(),
                                name = obj["name"].toString(),
                                status = "불가",
                                userId = obj["userId"].toString(),
                                userPhone = obj["userPhone"].toString(),
                                rentDate = obj["rentDate"].toString(),
                                returnDate = obj["returnDate"].toString(),
                                enable = false
                            )
                            temp.color = Color.parseColor("#d4e7fd")
                            temp.textColor = Color.parseColor("#5093f8")
                        }
                            list.add(temp)

                    }
                    val intent = Intent(this, RentActivity::class.java)
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
}
