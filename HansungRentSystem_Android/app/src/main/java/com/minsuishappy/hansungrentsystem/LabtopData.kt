package com.minsuishappy.hansungrentsystem

import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


class LabtopData public constructor(val img:Drawable, val name: String, val code: String) : Serializable{

    fun printString() {
        println("img : $img, title : $name, sub : $code")
    }
}


