package com.example.diceroller

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Tiradas")

data class Tiradas(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "Fecha")
    val fecha: String,
    @ColumnInfo(name = "Dado_1")
    val dado_1: Int,
    @ColumnInfo(name = "Dado_2")
    val dado_2: Int

)
