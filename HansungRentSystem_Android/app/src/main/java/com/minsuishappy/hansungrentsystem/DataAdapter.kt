package com.minsuishappy.hansungrentsystem


import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.NonNull
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.notebook_list.view.*

class DataAdapter(private val items: ArrayList<LabtopData>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    var context: Context? = null
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var view: View = v
        fun bind(listener: View.OnClickListener, item: LabtopData) {

            view.img_title.setImageDrawable(item.img)
            view.txt_title.text = item.name
            view.txt_subtitle.text = item.code
            val btn = view.findViewById<Button>(R.id.notebooklistBtn)
            btn.setOnClickListener(listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.notebook_list, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener { it ->
            val intent = Intent(holder.itemView.context, NotebookDeActivity::class.java)
            item.printString()

            intent.putExtra("name", item.name)
            intent.putExtra("code", item.code)
            intent.putExtra("cpu", item.cpu)
            intent.putExtra("memo", item.memo)
            intent.putExtra("card", item.card)
            intent.putExtra("screen", item.screen)
            intent.putExtra("weight", item.weight)
            startActivity(holder.itemView.context, intent, null)
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun getItemCount(): Int = items.size
}