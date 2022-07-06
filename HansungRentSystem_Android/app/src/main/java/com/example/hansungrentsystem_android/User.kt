package com.example.hansungrentsystem_android

import android.content.Context
import android.util.Log

class User private constructor() {

    var userId : String = ""
    var userName : String = ""
    var Type : String = ""
    var password : String = ""
    var userPhone : String = ""
    var isRented : String = ""

    // 파라메터를 받는 싱글톤 클래스를 만들려면 companion object를 이용한다.
    companion object {
        private var instance: User? = null

        private lateinit var context: Context

        fun getInstance(_context: Context): User {
            return instance ?: synchronized(this) {
                instance ?: User().also {
                    context = _context
                    instance = it
                }
            }
        }
    }

    fun setData(userId:String, userName:String, Type:String, password:String, userPhone:String, isRented:String) {
        this.userId = userId
        this.userName = userName
        this.Type = Type
        this.password = password
        this.userPhone = userPhone
        this.isRented = isRented
    }
}


