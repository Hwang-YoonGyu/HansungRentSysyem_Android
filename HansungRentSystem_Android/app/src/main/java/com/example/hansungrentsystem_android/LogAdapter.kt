package com.example.hansungrentsystem_android

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.item_list.view.code
import kotlinx.android.synthetic.main.item_list.view.rentDate
import kotlinx.android.synthetic.main.item_log.view.*

class LogAdapter(private val items: ArrayList<Log>): RecyclerView.Adapter<LogAdapter.MainViewHolder>()
{
    class MainViewHolder(v: View): RecyclerView.ViewHolder(v)
    {
        private var view: View = v
        fun bind(item:Log)
        {
            view.code.text = item.code
            view.rentDate.text = item.rentDate
            view.returnDate.text = "~"+item.returnDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_log, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int)
    {
        val item = items[position]

        holder.apply {
            bind(item)
            itemView.tag = item
        }
    }

    override fun getItemCount(): Int = items.size
}