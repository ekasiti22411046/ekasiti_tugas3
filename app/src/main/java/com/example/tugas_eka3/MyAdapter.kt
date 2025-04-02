package com.example.tugas_eka3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val namaList : ArrayList<ItemData>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder (itemData: View) : RecyclerView.ViewHolder (itemData) {
        val gambar: ImageView = itemData.findViewById(R.id.imageView)
        val nama: TextView = itemData.findViewById(R.id.Nama)
        val desk: TextView = itemData.findViewById(R.id.ket)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemData = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MyViewHolder(itemData)
    }

    override fun getItemCount(): Int = namaList.size

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.desk.text = currentItem.ket

    }


}