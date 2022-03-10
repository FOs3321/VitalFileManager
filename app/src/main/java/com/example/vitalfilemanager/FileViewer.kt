package com.example.vitalfilemanager

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.wear.widget.WearableRecyclerView
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FileViewer: Activity() {


    private lateinit var recyclerView: WearableRecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<*>

    private lateinit var data: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val filename = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val filepath = File("/storage/self/primary/Android/data/com.example.vitalstore_forwearos/files/" + filename)
        val fileReader = FileReader(filepath)
        val bufferedReader = BufferedReader(fileReader)

        data = bufferedReader.readLines()
    }
}

