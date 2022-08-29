package com.minsuishappy.hansungrentsystem


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_notebooklist.*

class DataActivity : AppCompatActivity() {

    var list = ArrayList<LabtopData>()
    var adapter : DataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notebooklist)

        list.add(LabtopData(getDrawable(R.drawable.macbookpro)!!, "MacBook Pro", "MVVJ2KH/A", "i7-9750H", "16GB", "라데온 Pro 5300M", "40.8cm(16인치)", "2.0kg"))
        list.add(LabtopData(getDrawable(R.drawable.macbookair)!!, "MacBook Air", "MGN63KH/A", "Apple Silicon M1", "8GB", "Apple silicon M1", "33.78cm(13.3인치)", "1.29kg"))
        list.add(LabtopData(getDrawable(R.drawable.odyssey)!!, "Odyssey", "NT800G5W-XD71", "i7-7700HQ", "8GB", "GTX1050", "39.62cm(15.6인치)", "2.5kg"))
        list.add(LabtopData(getDrawable(R.drawable.odyssey)!!, "Odyssey", "NT800G5W-XD7S", "i7-7700HQ", "8GB", "GTX1050", "39.62cm(15.6인치)", "2.5kg"))
        list.add(LabtopData(getDrawable(R.drawable.odyssey)!!, "Odyssey", "NT800G5W-GD7A", "i7-7700HQ", "GTX1050", "39.62cm(15.6인치)", "2.5kg", "2.5kg"))
        list.add(LabtopData(getDrawable(R.drawable.odyssey)!!, "Odyssey", "NT801G5H-X01/C", "i7-7700HQ", "16GB", "GTX1060", "39.62cm(15.6인치)", "2.5kg"))
        list.add(LabtopData(getDrawable(R.drawable.gram)!!, "Gram", "15Z90N-VP70ML", "i7-1065G7", "8GB", "인텔 Iris Plus Graphics", "39.62cm(15.6인치)", "1120g"))
        list.add(LabtopData(getDrawable(R.drawable.sword)!!, "Sword", "GF66-A11UD", "i7-11세대", "8GB", "RTX3050 Ti", "39.62cm(15.6인치)", "2.25kg"))



//        list.add(LabtopData("MacBook Pro", "MVVJ2KH/A"))
//        list.add(LabtopData("MacBook Air", "MGN63KH/A"))
//        list.add(LabtopData( "Odyssey", "NT800G5W-XD71"))
//        list.add(LabtopData( "Odyssey", "NT800G5W-XD7S"))
//        list.add(LabtopData("Odyssey", "NT800G5W-GD7A"))
//        list.add(LabtopData( "Odyssey", "NT801G5H-X01/C"))
//        list.add(LabtopData( "Gram", "15Z90N-VP70ML"))
//        list.add(LabtopData("SWORD", "GF66-A11UD"))

        adapter = DataAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        rv.layoutManager = layoutManager
        rv.adapter = adapter

        val back = findViewById<TextView>(R.id.list_backBtn)
        back.setOnClickListener {
            onBackPressed()
        }
    }
}
