package com.minsuishappy.hansungrentsystem


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.notebook_list.view.*

class DataAdapter(private val items: ArrayList<Data>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    var context: Context? = null

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var view: View = v
        fun bind(listener: View.OnClickListener, item: Data) {
            view.img_title.setImageDrawable(item.img)
            view.txt_title.text = item.title
            view.txt_subtitle.text = item.sub
            val btn = view.findViewById<Button>(R.id.notebooklistBtn)
            btn.setOnClickListener(listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.notebook_list, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener { it ->
            val intent = Intent(holder.itemView.context, NotebookDeActivity::class.java)

            intent.putExtra("obj", item)
            startActivity(holder.itemView.context, intent, null)
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun getItemCount(): Int = items.size
}