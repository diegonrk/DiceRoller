package com.example.diceroller

import android.app.Application

class DiceRollerApplication: Application() {
    val tiradasRepository: TiradasRepository by lazy {
        val database = TiradasDataBase.getDataBase(this)
        TiradasRepository(database.TiradasDAO())
    }
}