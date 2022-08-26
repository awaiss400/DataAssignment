package com.example.dataassignment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.*
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {
//   val viewModel:MyViewModel by activityViewModels()
val viewModel: MyViewModel by hiltNavGraphViewModels(R.id.my_nav)
// activity view midel when viewmdel is shared other only viewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view= inflater.inflate(R.layout.fragment_profile, container, false)

//        val  viewModel= ViewModelProvider(this)[MyViewModel::class.java]
        val xname: EditText = view.findViewById(R.id.username)
        val xaddress: EditText = view.findViewById(R.id.useraddress)
        val xmail: EditText = view.findViewById(R.id.usermail)
        val addtodatabasebtn: Button = view.findViewById(R.id.addtodbbutton)
        addtodatabasebtn.setOnClickListener {
            val name=xname.text.toString()
            val addrss=xaddress.text.toString()
            val mail=xmail.text.toString()
            viewModel.insert(Users(0,name,addrss,mail))
            Toast.makeText(context, "Done", Toast.LENGTH_LONG).show()
            xname.text.clear()
            xaddress.text.clear()
            xmail.text.clear()
            Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_homeFragment)

        }
        return view }


}
