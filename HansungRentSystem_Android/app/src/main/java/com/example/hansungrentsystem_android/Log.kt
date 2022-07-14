package com.example.hansungrentsystem_android

import android.content.Context
import java.io.Serializable

class Log public constructor(): Serializable {

    var userId : String = ""
    var code : String = ""
    var rentDate : String = ""
    var returnDate : String = ""

    // 파라메터를 받는 싱글톤 클래스를 만들려면 companion object를 이용한다.

    fun setData(userId:String, code:String, rentDate:String, returnDate:String) {
        this.userId = userId
        this.code = code
        this.rentDate = rentDate
        this.returnDate = returnDate
    }
}
