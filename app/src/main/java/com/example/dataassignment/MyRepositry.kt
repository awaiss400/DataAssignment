package com.example.dataassignment

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
//
//class MyRepositry @Inject constructor( val userDao: UsersDao) {
//    suspend fun readalluser():List<Users>  {
//        return userDao.readalldata()
//
//    }
//     suspend    fun insert(users: Users) {
//        userDao.insert(users)
//
//    }
//
//}
interface MyRepositry {
    suspend fun readalluser():List<Users>
    suspend fun insert(users: Users)
}