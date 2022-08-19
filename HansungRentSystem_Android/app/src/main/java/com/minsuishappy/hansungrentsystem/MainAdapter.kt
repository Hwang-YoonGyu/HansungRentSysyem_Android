package com.minsuishappy.hansungrentsystem

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter(private val items: ArrayList<ObjectLaptop>): RecyclerView.Adapter<MainAdapter.MainViewHolder>()
{
    var lastPosition: Int = -1
    var context: Context? =null
    class MainViewHolder(v: View): RecyclerView.ViewHolder(v)
    {
        var view: View = v
        fun bind(listener: View.OnClickListener, item: ObjectLaptop)
        {
            view.code.text = item.name
            view.rentDate.text = item.code
            view.button.text = item.status
            view.button.isEnabled = item.enable
            view.button.setBackgroundColor(item.color)
            view.button.setTextColor((item.textColor))
            view.button.setOnClickListener(listener)
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder
    {
       context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MainViewHolder(view)
    }



    override fun onBindViewHolder(@NonNull holder: MainViewHolder, position: Int)
    {
        if(holder.adapterPosition > lastPosition) {
            val item = items[position]
            val listener = View.OnClickListener { it ->
                val intent = Intent(holder.itemView.context, DetailActivity::class.java)

                intent.putExtra("obj", item)
                startActivity(holder.itemView.context, intent, null)
            }
            holder.apply {
                bind(listener, item)
                itemView.tag = item
            }
            val animation = AnimationUtils.loadAnimation(context, R.anim.item_anim)
            holder.view.startAnimation(animation)
        }
    }

    override fun getItemCount(): Int = items.size
}


