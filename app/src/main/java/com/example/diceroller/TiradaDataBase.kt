package com.example.diceroller

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Tiradas::class], version = 1)
abstract class TiradasDataBase: RoomDatabase() {
    abstract fun TiradasDAO(): TiradasDAO

    companion object{
        @Volatile
        private var INSTANCE: TiradasDataBase? = null

        fun getDataBase(context: Context): TiradasDataBase {
            return INSTANCE ?: synchronized(this){
                val instance = databaseBuilder(
                    context,
                    TiradasDataBase::class.java,
                    "TiradasDataBase")

                    .build()
                INSTANCE = instance

                instance
            }
        }

    }

}


