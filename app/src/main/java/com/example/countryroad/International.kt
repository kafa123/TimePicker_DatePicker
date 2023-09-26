package com.example.countryroad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class International : AppCompatActivity() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var TujuanList: ArrayList<Tujuan>
    lateinit var imageId:Array<Int>
    lateinit var country : Array<String>
    lateinit var text : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_international)

        imageId = arrayOf(
            R.drawable.china,
            R.drawable.england,
            R.drawable.jepang,
            R.drawable.usa,
            R.drawable.italia,
        )
        country = arrayOf(
            "CHINA",
            "INGGRIS",
            "JEPANG",
            "AMERIKA",
            "ITALIA",
        )
        text = arrayOf(
            "Temukan keajaiban dunia di destinasi internasional terbaik. Bergabunglah dengan perjalanan tak terlupakan bersama kami!",
            "Temukan keajaiban dunia di destinasi internasional terbaik. Bergabunglah dengan perjalanan tak terlupakan bersama kami!",
            "Temukan keajaiban dunia di destinasi internasional terbaik. Bergabunglah dengan perjalanan tak terlupakan bersama kami!",
            "Temukan keajaiban dunia di destinasi internasional terbaik. Bergabunglah dengan perjalanan tak terlupakan bersama kami!",
            "Temukan keajaiban dunia di destinasi internasional terbaik. Bergabunglah dengan perjalanan tak terlupakan bersama kami!"

        )
        myRecyclerView= findViewById(R.id.recycleViewInternational)
        myRecyclerView.layoutManager= LinearLayoutManager(this)
        myRecyclerView.setHasFixedSize(true)

        TujuanList= arrayListOf<Tujuan>()
        getUserData()
    }
    private fun getUserData(){
        for (i in imageId.indices){
            val tujuan = Tujuan(imageId[i],country[i],text[i])
            TujuanList.add(tujuan)
        }

        val adapter=MyAdapter(TujuanList)
        myRecyclerView.adapter = adapter

    }
}
