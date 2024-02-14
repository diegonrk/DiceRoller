package com.example.diceroller

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TiradasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textViewFechaDado1Dado2: TextView = itemView.findViewById(R.id.textViewFechaDado1Dado2)

    fun bind(tirada: Tiradas) {
        val tiradaText = "Id: ${tirada.id}  -  ${tirada.fecha}  -  Dado 1: ${tirada.dado_1}  |  Dado 2: ${tirada.dado_2}"
        textViewFechaDado1Dado2.text = tiradaText


    }
}