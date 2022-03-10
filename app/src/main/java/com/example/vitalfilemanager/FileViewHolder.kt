package com.example.vitalfilemanager

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var fileView: TextView

    init {
        fileView = itemView.findViewById(R.id.textView)
    }
}