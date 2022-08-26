package com.example.dataassignment.DI

import com.example.dataassignment.MyRepositoryImpl
import com.example.dataassignment.MyRepositry
import com.example.dataassignment.UsersDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesRepository(impl: MyRepositoryImpl): MyRepositry
}