package com.gaurneev.gdsccolorgame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class myColour(val id:Int, val naame:String)

class colorAdapter(private val colour: MutableList<String>):RecyclerView.Adapter<colorAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.clName.text = colour[position]
    }

    override fun getItemCount(): Int {
        return colour.size
    }

    fun addItem(item: String){
        colour.add(item)
        notifyItemInserted(colour.size-1)
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var clName = itemView.findViewById<TextView>(R.id.colorName)
    }
}

var fList= mutableListOf<String>()


