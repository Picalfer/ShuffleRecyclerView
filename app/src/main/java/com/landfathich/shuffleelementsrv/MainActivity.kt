package com.landfathich.shuffleelementsrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val refresh = findViewById<Button>(R.id.refresh)

        val list = getArray30()

        val adapter = MyAdapter(list)
        recyclerView.adapter = adapter

        refresh.setOnClickListener {
            mixing(adapter)
        }
    }

    private fun getArray30(): ArrayList<Int> {
        val list = arrayListOf<Int>()
        for (i in 1..30) {
            list.add(i)
        }
        return list
    }

    private fun mixing(adapter: MyAdapter) {
        val oldList = adapter.data

        val newList = getArray30()
        newList.shuffle()

        val numbersDiff = DiffNumbers(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(numbersDiff)

        adapter.data = newList
        diffResult.dispatchUpdatesTo(adapter)
    }
}