package com.minsuishappy.hansungrentsystem

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rent.*

class RentActivity : AppCompatActivity() {
    init{
        instance = this
    }
    companion object{
        private var instance: RentActivity? = null
        fun getInstance(): RentActivity? {
            return instance
        }
    }

    var list = ArrayList<ObjectLaptop>()
    var adapter : MainAdapter? = null

    fun changeMethod(code : String) {
        for (i in 0..list.size) {
            if (list.get(i).code.equals(code)) {
                list.get(i).status = "불가"
                list.get(i).enable = false
                list.get(i).color = Color.parseColor("#d4e7fd")
                list.get(i).textColor = Color.parseColor("#5093f8")
                break
            }
        }
    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent)
        list = intent.getSerializableExtra("list") as ArrayList<ObjectLaptop>

        adapter = MainAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adapter

        val back = findViewById<TextView>(R.id.rent_backBtn)
        back.setOnClickListener {
            onBackPressed()
        }
    }
}