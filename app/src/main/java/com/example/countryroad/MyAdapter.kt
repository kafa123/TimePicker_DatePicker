package com.example.countryroad

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.countryroad.R

class MyAdapter(private var TujuanList:ArrayList<Tujuan>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val tujuanView = LayoutInflater.from(parent.context).inflate(R.layout.card_recycle,
            parent,false)
        return MyViewHolder(tujuanView)
    }

    override fun getItemCount(): Int {
        return TujuanList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val currentTujuan = TujuanList[position]
        holder.imageCard.setImageResource(currentTujuan.imageCard)
        holder.cardText.text=currentTujuan.cardText
        holder.country.text=currentTujuan.country

        var countryPass=holder.country.text
        holder.buttonToPesan.setOnClickListener {
            val context =holder.itemView.context
            val intent = Intent(context,PesanActivity::class.java)
            intent.putExtra("COUNTRY_NAME",countryPass)
            context.startActivity(intent)
        }

    }
    class MyViewHolder(tujuanView : View):RecyclerView.ViewHolder(tujuanView){
        val imageCard : ImageView = tujuanView.findViewById(R.id.imageCard)
        val cardText : TextView = tujuanView.findViewById(R.id.cardText)
        val country : TextView = tujuanView.findViewById(R.id.Country)
        val buttonToPesan : Button = tujuanView.findViewById(R.id.btnToPesan)
    }
}