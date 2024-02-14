package com.example.diceroller

import androidx.lifecycle.LiveData

class TiradasRepository(private val tiradasDAO: TiradasDAO) {
    fun getAllTiradas(): LiveData<List<Tiradas>> {
        return tiradasDAO.getAll()
    }

    suspend fun insertTirada(tirada: Tiradas) {
        tiradasDAO.insertar(tirada)
    }
}