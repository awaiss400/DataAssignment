package com.example.dataassignment

import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(val userDao: UsersDao):MyRepositry {
    override suspend fun readalluser(): List<Users> {
        return userDao.readalldata()
    }

    override suspend fun insert(users: Users) {
        userDao.insert(users)
    }
}