package com.example.vitalfilemanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.wear.widget.WearableLinearLayoutManager
import androidx.wear.widget.WearableRecyclerView
import com.example.vitalfilemanager.databinding.ActivityMainBinding
import java.io.File


class MainActivity : Activity() {

    companion object {
        const val EXTRA_MESSAGE = "com.example.vitalfilemanager.MESSAGE"
    }
    private lateinit var binding: ActivityMainBinding

    private lateinit var recyclerView: WearableRecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<*>

    private lateinit var data: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val file = File("/storage/self/primary/Android/data/com.example.vitalstore_forwearos/files")
        data = file.list().toMutableList()



        layoutManager = WearableLinearLayoutManager(this)
        adapter = FileViewAdapter(data)
        recyclerView = findViewById<WearableRecyclerView>(R.id.recycler_launcher_view).also {
//            it.isEdgeItemsCenteringEnabled = true
            it.layoutManager = layoutManager
            it.adapter = adapter
//            it.isCircularScrollingGestureEnabled = true
//            it.bezelFraction = 0.5f
//            it.scrollDegreesPerScreen = 90f
        }

    }

    private fun openHRData(view: View){
        val filename = view.findViewById<TextView>(R.id.textView).text
        val intent = Intent(application, FileViewer::class.java)
        intent.putExtra(EXTRA_MESSAGE, filename)
        startActivity(intent)
    }
}