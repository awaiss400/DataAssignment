    package com.example.dataassignment
import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.WorkerThread
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.*
import kotlinx.coroutines.NonDisposableHandle.parent
import java.util.zip.Inflater
import kotlin.contracts.contract
class MyAdapters():RecyclerView.Adapter<MyAdapters.MyViewHolder>() {
    var allusers:List<Users>? = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.itemsforrecycler, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentuser = allusers!![position]
        holder.recname.text = currentuser.name
        holder.recaddress.text = currentuser.address
        holder.recmail.text = currentuser.mail
    }
    override fun getItemCount(): Int {
        return allusers!!.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recname: TextView = itemView.findViewById(R.id.recyclername)
        var recaddress: TextView = itemView.findViewById(R.id.recycleraddress)
        var recmail: TextView = itemView.findViewById(R.id.recyclermail)
    }
    fun setdata(data: List<Users>) {
this.allusers=data
        notifyDataSetChanged()
    }
}