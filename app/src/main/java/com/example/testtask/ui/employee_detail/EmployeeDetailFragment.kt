package com.example.testtask.ui.employee_detail


import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.testtask.R
import com.example.testtask.data_source.Repository
import com.example.testtask.ui.MainActivity
import com.example.testtask.ui.employees.EmployeesViewModel
import com.example.testtask.ui.specialities.SpecialititesViewModel

class EmployeeDetailFragment(val repository: Repository) : androidx.fragment.app.Fragment() {
    val viewModel: SpecialititesViewModel by viewModels{EmployeeDetailViewModelFactory((activity as MainActivity).repository)}
    val args: EmployeeDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employee_detail_fragment, container, false)
    }

}

@Suppress("UNCHECKED_CAST")
class EmployeeDetailViewModelFactory(val repository: Repository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeDetailViewModel(repository) as T
    }
}