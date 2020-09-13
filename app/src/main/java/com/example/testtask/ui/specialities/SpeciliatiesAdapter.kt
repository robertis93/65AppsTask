package com.example.testtask.ui.specialities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import com.example.testtask.data.Speciality
import kotlinx.android.synthetic.main.speciality_item.view.*

class SpeciliatiesAdapter(val specialities : List<Speciality>,  val listener: Listener): RecyclerView.Adapter< SpeciliatiesAdapter.SpecialitiesViewHolder>() {

    interface Listener {
        fun onItemClick(speciality: Speciality)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialitiesViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.speciality_item, parent, false)
        val viewHolder = SpecialitiesViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return specialities.size
    }

    override fun onBindViewHolder(holder: SpecialitiesViewHolder, position: Int) {
        holder.bind(specialities[position])
        holder.itemView.setOnClickListener {
            listener.onItemClick(specialities[position])

        }
    }



    class SpecialitiesViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(speciality : Speciality){
            itemView.specialityId.text = speciality.id.toString()
            itemView.speciality_name.text = speciality.name
        }
    }



}