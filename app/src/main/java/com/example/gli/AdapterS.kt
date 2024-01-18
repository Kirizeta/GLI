package com.example.gli

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterS (private val userList : ArrayList<User>) : RecyclerView.Adapter<AdapterS.StudentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemstudent, parent, false)
        return StudentViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val  curritem = userList[position]
        holder.nama.text = curritem.nama
        holder.alamat.text = curritem.alamat
        Picasso.get().load(curritem.photo).into(holder.photo)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class StudentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nama : TextView = itemView.findViewById(R.id.nama)
        val alamat : TextView = itemView.findViewById(R.id.alamat)
        val photo : ImageView = itemView.findViewById(R.id.photo)

    }

}