package com.example.dataassignment

import android.app.Application
import androidx.lifecycle.*
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MyViewModel @Inject constructor(val repositoryImpl:MyRepositry) : ViewModel() {
    var readalldata:MutableLiveData<List<Users>> =MutableLiveData<List<Users>>()

    fun insert(users: Users)=viewModelScope.launch(Dispatchers.IO) {
        repositoryImpl.insert(users)
    }
fun getuser(){
 viewModelScope.launch {

     readalldata.postValue( repositoryImpl.readalluser())
 }
}
}