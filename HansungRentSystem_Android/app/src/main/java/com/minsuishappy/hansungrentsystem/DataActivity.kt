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

        list.add(LabtopData(getDrawable(R.drawable.macbookpro)!!, "MacBook Pro", "MVVJ2KH/A"))
        list.add(LabtopData(getDrawable(R.drawable.macbookair)!!, "MacBook Air", "MGN63KH/A"))
        list.add(LabtopData(getDrawable(R.drawable.odyssey)!!, "Odyssey", "NT800G5W-XD71"))
        list.add(LabtopData(getDrawable(R.drawable.odyssey)!!, "Odyssey", "NT800G5W-XD7S"))
        list.add(LabtopData(getDrawable(R.drawable.odyssey)!!, "Odyssey", "NT800G5W-GD7A"))
        list.add(LabtopData(getDrawable(R.drawable.odyssey)!!, "Odyssey", "NT801G5H-X01/C"))
        list.add(LabtopData(getDrawable(R.drawable.gram)!!, "Gram", "15Z90N-VP70ML"))
        list.add(LabtopData(getDrawable(R.drawable.sword)!!, "Sword", "GF66-A11UD"))



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
