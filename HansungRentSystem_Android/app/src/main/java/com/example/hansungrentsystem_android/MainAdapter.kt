package com.example.hansungrentsystem_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter(private val items: ArrayList<MainData>): RecyclerView.Adapter<MainAdapter.MainViewHolder>()
{
    class MainViewHolder(v: View): RecyclerView.ViewHolder(v)
    {
        private var view: View = v
        fun bind(listener: View.OnClickListener, item:MainData)
        {
            view.name.text = item.name
            view.number.text = item.number
            view.setOnClickListener(listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int)
    {
        val item = items[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "클릭한 아이템의 이름 : ${item.name}", Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun getItemCount(): Int = items.size
}


