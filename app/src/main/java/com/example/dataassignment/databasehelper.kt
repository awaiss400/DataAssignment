package com.example.dataassignment

import android.content.Context
import androidx.room.Room

class databasehelper(val context: Context) {
    fun builddatabase(){
        Room.databaseBuilder(context,Mydatabase::class.java,"mydb").build()
    }
}