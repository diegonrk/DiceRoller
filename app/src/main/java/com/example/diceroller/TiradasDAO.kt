package com.example.diceroller

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TiradasDAO {
    @Insert
    suspend fun insertar(entidad: Tiradas)

    @Query("SELECT * FROM Tiradas order by id desc")
    fun getAll(): LiveData<List<Tiradas>>

    @Query("DELETE FROM Tiradas")
    suspend fun clearAll()


}