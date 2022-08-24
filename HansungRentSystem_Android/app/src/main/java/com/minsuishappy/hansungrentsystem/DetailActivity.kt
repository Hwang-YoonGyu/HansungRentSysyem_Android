package com.minsuishappy.hansungrentsystem

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
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

        if (user.isRented.equals("1")) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("").setMessage("중복대여가 불가합니다.").setPositiveButton("확인", {dialogInterface: DialogInterface, i:Int ->
                onBackPressed()
            })
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }

        rentBtn.setOnClickListener {
            thread(start = true) {
                try {
                    var urlText =
                        "http://13.125.253.41:8080/API/Rent?code="+obj.code+
                                "&userId="+user.userId+
                                "&userPhone="+user.userPhone+
                                "&rentDate="+rentDate.text+
                                "&returnDate="+returnDate.text

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
                        val result =json["result"].toString()


                        if (result.equals("1")) {
                            this.runOnUiThread {
                                rentActivity?.changeMethod(obj.code)
                                user.isRented = "1"
                                val builder = AlertDialog.Builder(this)
                                builder.setTitle("").setMessage("대여신청이 완료되었습니다. \n승인여부를 곧 알림으로 알려드리겠습니다.")
                                    .setPositiveButton(
                                        "확인",
                                        { dialogInterface: DialogInterface, i: Int ->
                                            onBackPressed()
                                        })
                                val alertDialog: AlertDialog = builder.create()
                                alertDialog.show()
                            }
                        }
                        else if (result.equals("0")) {
                            this.runOnUiThread {
                                rentActivity?.changeMethod(obj.code)
                                val builder = AlertDialog.Builder(this)
                                builder.setTitle("").setMessage("이미 대여된 기자재입니다. 다른 기자재를 선택해주세요.")
                                    .setPositiveButton(
                                        "확인",
                                        { dialogInterface: DialogInterface, i: Int ->
                                            onBackPressed()
                                        })
                                val alertDialog: AlertDialog = builder.create()
                                alertDialog.show()
                            }
                        }
                    }

                } catch (e: Exception) {
                    this.runOnUiThread {
                        System.out.println("오류 : "+e.toString());
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("").setMessage("API서버 오류입니다. 잠시 후에 다시 시도해 주세요.").setPositiveButton("확인", { _: DialogInterface, i:Int ->
                            onBackPressed()
                        })
                        val alertDialog: AlertDialog = builder.create()
                        alertDialog.show()
                    }
                }

            }
        }
        cancelBtn.setOnClickListener {
            onBackPressed()
        }



    }
}