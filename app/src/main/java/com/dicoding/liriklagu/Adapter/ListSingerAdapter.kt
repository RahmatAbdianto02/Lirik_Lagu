package com.dicoding.liriklagu.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.liriklagu.Data.Singer
import com.dicoding.liriklagu.DetailLirik.DetailActivity
import com.dicoding.liriklagu.R

class ListSingerAdapter(private  val listSinger: ArrayList<Singer>) : RecyclerView.Adapter<ListSingerAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_lirik,parent,false)
        return  ListViewHolder(view)
    }

    override fun getItemCount(): Int  = listSinger.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,description,photo) = listSinger[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context,DetailActivity::class.java)
            intentDetail.putExtra("key_lirik",listSinger[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}