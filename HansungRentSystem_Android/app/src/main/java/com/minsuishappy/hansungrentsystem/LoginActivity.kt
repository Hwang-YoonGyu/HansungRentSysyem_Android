package com.minsuishappy.hansungrentsystem

import android.app.AlertDialog
import android.content.ClipboardManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import org.json.JSONObject
import java.io.*
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.Exception
import kotlin.concurrent.thread

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        FirebaseApp.initializeApp(this)



        var token = "";
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener {  task ->
            if (!task.isSuccessful) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@fail")
                return@OnCompleteListener
            }
            val token = task.result

            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+token)
            User.getInstance(this).setFbToken(token)

        })

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val idField = findViewById<EditText>(R.id.idField)
        val pwdField = findViewById<EditText>(R.id.pwdField)

        try {
            var filePath = filesDir.path + "/login.txt"
            val file = File(filePath)
            val fileReader = FileReader(file)

            var loginInfo = fileReader.readText()
            if(loginInfo.isEmpty()) {
                println("No data")
            }
            else{
                var temp = loginInfo.split(" ")
                doLogin(temp[0], temp[1])
            }
        }catch (e:Exception){
        }


        loginBtn.setOnClickListener {
            doLogin(idField.text.toString(), pwdField.text.toString())
        }
    }

    fun doLogin(id:String, pwd:String) {
        this.runOnUiThread {

        }
        thread(start = true) {
            try {
                val autoLogin = findViewById<CheckBox>(R.id.checkBox)
                var urlText = "http://13.125.253.41:8080/API/login?userId="+id+"&password="+pwd

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

                    if(autoLogin.isChecked){
                        var filePath = filesDir.path + "/login.txt"
                        val file = File(filePath)
                        val fileWriter = FileWriter(file, false)
                        var loginInfo = id + " " + pwd

                        fileWriter.write(loginInfo)
                        fileWriter.close()

                    }

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