package com.landfathich.shuffleelementsrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf<Int>()
        for (i in 1..30) {
            list.add(i)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val refresh = findViewById<Button>(R.id.refresh)

        val adapter = MyAdapter(list)
        recyclerView.adapter = adapter

        refresh.setOnClickListener {
            list.shuffle()
            adapter.notifyDataSetChanged()
        }
    }
}