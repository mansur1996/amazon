package com.example.modul5lesson6.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson6.R
import com.example.modul5lesson6.model.Essential

class EssentialAdapter(var context: Context, var items : ArrayList<Essential>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EssentialViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_essentional, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is EssentialViewHolder){
            holder.apply {
                tv_title.text = item.title
                iv_image.setImageResource(item.image)
            }
        }
    }

    override fun getItemCount() = items.size

    class EssentialViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var tv_title = view.findViewById<TextView>(R.id.tv_title)
        var iv_image = view.findViewById<ImageView>(R.id.iv_image)
    }
}