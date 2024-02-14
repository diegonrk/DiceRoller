package com.example.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TiradasViewModel(private val repository: TiradasRepository) : ViewModel() {
    val allTiradas: LiveData<List<Tiradas>> = repository.getAllTiradas()


}

class TiradasViewModelFactory(private val tiradasRepository: TiradasRepository) : ViewModelProvider.Factory {
     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TiradasViewModel::class.java)) {
            return TiradasViewModel(tiradasRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}