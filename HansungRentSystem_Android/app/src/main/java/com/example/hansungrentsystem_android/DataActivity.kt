package com.example.hansungrentsystem_android


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_notebooklist.*

class DataActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notebooklist)



        val list = ArrayList<Data>()
        val adapter = DataAdapter(list)
        list.add(Data(getDrawable(R.drawable.macbookpro)!!,"MackBookPro","MVVJ2KH/A"))
        list.add(Data(getDrawable(R.drawable.macbookair)!!,"MacBookAir","MGN63KH/A"))
        list.add(Data(getDrawable(R.drawable.odyssey)!!,"Odyssey","NT800G5W-XD71"))
        list.add(Data(getDrawable(R.drawable.odyssey)!!,"Odyssey","NT800G5W-XD7S"))
        list.add(Data(getDrawable(R.drawable.odyssey)!!,"Odyssey","NT800G5W-GD7A"))
        list.add(Data(getDrawable(R.drawable.odyssey)!!,"Odyssey","NT801G5H-X01/C"))
        list.add(Data(getDrawable(R.drawable.gram)!!,"Gram","15Z90N-VP70ML"))
        list.add(Data(getDrawable(R.drawable.sword)!!,"MSI","GF66-A11UD"))
        val layoutManager =LinearLayoutManager(this)


        rv.adapter = adapter
        rv.layoutManager = layoutManager


        val back = findViewById<TextView>(R.id.list_backBtn)
        back.setOnClickListener {
            onBackPressed()
        }




    }


}
