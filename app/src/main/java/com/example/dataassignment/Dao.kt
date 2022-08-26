package com.example.dataassignment
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao interface UsersDao {
   @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(users: Users)
@Query("SELECT * FROM users ORDER BY id DESC")

suspend fun readalldata():List<Users>
//    suspend fun readalldata():LiveData<List<Users>>

}