package com.example.vitalfilemanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FileViewAdapter(
    private val list: List<String>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ListListener {
        fun onClickItem(tappedView: View, itemModel: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.file_view, parent, false)
        return FileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.textView).text = list[position]
        holder.itemView.findViewById<TextView>(R.id.textView).text = list[position]
    }

    override fun getItemCount(): Int = list.size
}