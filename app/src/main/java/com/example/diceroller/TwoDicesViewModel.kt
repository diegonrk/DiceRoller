package com.example.diceroller

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date

class TwoDicesViewModel(private val tiradasDao: TiradasDAO) : ViewModel() {
    private val dice1 = Dice(6)
    private val dice2 = Dice(6)


    val tiradas: LiveData<List<Tiradas>> = tiradasDao.getAll()

    init {
        Log.d("TwoDicesViewModel", "ViewModel creado")
    }

    fun rollDices() {
        val caraDado1 = dice1.roll()
        val caraDado2 = dice2.roll()


        val fechaActual = Date()
        val formato = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val fechaFormateada = formato.format(fechaActual)


        val tirada = Tiradas(
            id = 0,
            fecha = fechaFormateada,
            dado_1 = caraDado1,
            dado_2 = caraDado2

        )
        guardarTirada(tirada)
    }

    private fun guardarTirada(tirada: Tiradas) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                tiradasDao.insertar(tirada)
            }
        }
    }
}

class TwoDicesViewModelFactory(private val tiradasDao: TiradasDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TwoDicesViewModel::class.java)) {
            return TwoDicesViewModel(tiradasDao) as T
        }
        throw IllegalArgumentException("Clase ViewModel incorrecta para el Factory: ${modelClass.name}")
    }
}

