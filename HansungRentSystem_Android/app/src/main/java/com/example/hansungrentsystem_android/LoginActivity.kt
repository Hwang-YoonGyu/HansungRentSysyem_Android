package com.example.hansungrentsystem_android

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.lang.reflect.Type
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val idField = findViewById<EditText>(R.id.idField)
        val pwdField = findViewById<EditText>(R.id.pwdField)




        loginBtn.setOnClickListener {
            this.runOnUiThread {

            }
            thread(start = true) {
                try {
                    var urlText = "http://10.0.2.2:8080/API/login?userId="+idField.text+"&password="+pwdField.text

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
                        val pwd =json["password"].toString()
                        var user = User.getInstance(this)
                        user.setData(userId = json["id"].toString(), userName = json["userName"].toString(),Type= json["Type"].toString(), password = json["password"].toString(), userPhone = json["userPhone"].toString(), isRented = json["isRented"].toString())




                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("userId",user.userId)


                        startActivity(intent)
                    }

                } catch (e: Exception) {
                    this.runOnUiThread {
                        System.out.println("오류 : "+e.toString());
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("").setMessage("입력하신 정보가 올바르지 않습니다.").setPositiveButton("확인", { _: DialogInterface, i:Int ->
                        })
                        val alertDialog: AlertDialog = builder.create()
                        alertDialog.show()
                    }

                }

            }

        }




    }
}