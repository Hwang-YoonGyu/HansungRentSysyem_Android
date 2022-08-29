package com.minsuishappy.hansungrentsystem

import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


class LabtopData public constructor(val img:Drawable, val name: String, val code: String, val cpu: String, val memo: String, val card: String, val screen: String, val weight: String) : Serializable{

    fun printString() {
        println("img : $img, title : $name, sub : $code, cpu : $cpu, memo : $memo, card : $card, screen : $screen, weight : $weight")
    }
}


