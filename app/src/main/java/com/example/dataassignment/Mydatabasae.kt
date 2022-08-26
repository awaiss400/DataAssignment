package com.example.dataassignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class Mydatabase : RoomDatabase() {
    abstract fun userDao():UsersDao
    companion object{
       @Volatile
       private var INSTANCE:Mydatabase?=null

        fun getDatabase(context: Context): Mydatabase {
                      return INSTANCE ?: synchronized(this) {
                val instance = databaseBuilder(
                    context.applicationContext,
                    Mydatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance

                instance
            }
        }
}
}