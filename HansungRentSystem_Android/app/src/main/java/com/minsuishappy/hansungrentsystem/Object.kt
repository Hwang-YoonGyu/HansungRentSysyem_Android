package com.minsuishappy.hansungrentsystem

import android.graphics.Color
import java.io.Serializable

class ObjectLaptop public constructor() : Serializable {
    var code : String = ""
    var name : String = ""
    var status : String = ""
    var userId : String = ""
    var userPhone : String = ""
    var rentDate : String = ""
    var returnDate : String = ""
    var enable : Boolean = false
    var color : Int = Color.parseColor("#3378f7")
    var textColor : Int = Color.parseColor("#3378f7")
    public fun setData(code : String, name : String, status: String, userId : String, userPhone : String, rentDate :String, returnDate : String, enable : Boolean) {
        this.code = code
        this.name = name
        this.status = status
        this.userId = userId
        this.userPhone = userPhone
        this.rentDate = rentDate
        this.returnDate = returnDate
        this.enable = enable
    }

}