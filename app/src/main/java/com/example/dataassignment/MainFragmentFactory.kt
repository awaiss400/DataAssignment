package com.example.dataassignment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.activityViewModels
import javax.inject.Inject

class MainFragmentFactory @Inject constructor(val string: String)
: FragmentFactory(){
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
      return  when (className){ HomeFragment::class.java.name -> HomeFragment()
        else ->  super.instantiate(classLoader, className)
    }
      }}