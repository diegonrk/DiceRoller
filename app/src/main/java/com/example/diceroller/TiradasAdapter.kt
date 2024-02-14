package com.example.diceroller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TiradasAdapter(private var tiradasList: List<Tiradas>) : RecyclerView.Adapter<TiradasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiradasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tirada, parent, false)
        return TiradasViewHolder(view)
    }

    override fun onBindViewHolder(holder: TiradasViewHolder, position: Int) {
        val tirada = tiradasList[position]
        holder.bind(tirada)
    }

    override fun getItemCount(): Int {
        return tiradasList.size
    }
    fun updateList(newList: List<Tiradas>) {
        tiradasList = newList
        notifyDataSetChanged()
    }
}