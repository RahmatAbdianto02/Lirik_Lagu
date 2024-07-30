package com.dicoding.liriklagu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.liriklagu.Adapter.ListSingerAdapter
import com.dicoding.liriklagu.Data.Singer

class MainActivity : AppCompatActivity() {

    private lateinit var rvSinger: RecyclerView
    private val list = ArrayList<Singer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        rvSinger = findViewById(R.id.rv_penyanyi)
        rvSinger.setHasFixedSize(true)

        list.addAll(getListSinger())
        showRecycleList()
    }


    private fun getListSinger(): ArrayList<Singer> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSinger = ArrayList<Singer>()
        for (i in dataName.indices) {
            val singer = Singer(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listSinger.add(singer)
        }
        return listSinger
    }

    private fun showRecycleList(){
        rvSinger.layoutManager = LinearLayoutManager(this)
        val listSingerAdapter = ListSingerAdapter(list)
        rvSinger.adapter = listSingerAdapter
    }
}