package com.example.hansungrentsystem_android

import java.io.Serializable

class ObjectLaptop public constructor() : Serializable {
    var code : String = ""
    var name : String = ""
    var status : String = ""
    var userId : String = ""
    var userPhone : String = ""
    var rentDate : String = ""
    var returnDate : String = ""
    public fun setData(code : String, name : String, status: String, userId : String, userPhone : String, rentDate :String, returnDate : String) {
        this.code = code
        this.name = name
        this.status = status
        this.userId = userId
        this.userPhone = userPhone
        this.rentDate = rentDate
        this.returnDate = returnDate
    }

}