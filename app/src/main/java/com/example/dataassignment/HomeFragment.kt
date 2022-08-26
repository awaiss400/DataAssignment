package com.example.dataassignment
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class  HomeFragment : Fragment() {
//   val  viewModel:MyViewModel by activityViewModels(
val viewModel: MyViewModel by hiltNavGraphViewModels(R.id.my_nav)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_home, container, false)
        viewModel.getuser()
        val recyclerView=view.findViewById<RecyclerView>(R.id.containerforrecycler)
        val adapters=MyAdapters()
        recyclerView.adapter=adapters
        recyclerView.layoutManager=LinearLayoutManager(this.context)
        viewModel.readalldata.observe(viewLifecycleOwner,Observer{Users->
            adapters.setdata(Users)

        })
        viewModel.getuser()


        return view

    }
    }
