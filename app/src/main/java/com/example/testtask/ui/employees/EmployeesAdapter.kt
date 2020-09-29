package com.example.testtask.ui.employees

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import com.example.testtask.data.Employee
import kotlinx.android.synthetic.main.employee_item.view.*




class EmployeesAdapter(val employees : List<Employee>, val listener: Listener): RecyclerView.Adapter< EmployeesAdapter.EmployeesViewHolder>() {

    interface Listener {
        fun onItemClick(employee: Employee)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.employee_item, parent, false)
        val viewHolder = EmployeesViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {
        holder.bind(employees[position])
        holder.itemView.setOnClickListener {
            listener.onItemClick(employees[position])

        }
    }



    class EmployeesViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(employee: Employee){
            itemView.employee_name.text = employee.firstName
            itemView.employee_secondname.text = employee.lastName
            if (employee.getAge() == null) {
                itemView.employee_age.setText(R.string.null_age)
            } else
                itemView.employee_age.text = employee.getAge().toString()
        }
    }



}