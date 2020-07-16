package com.example.testtask.ui.employees



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testtask.R
import com.example.testtask.data_source.Repository
import com.example.testtask.ui.MainActivity
import com.example.testtask.ui.specialities.SpecialititesViewModel

class EmployeesFragment : androidx.fragment.app.Fragment() {
    val viewModel: EmployeesViewModel by viewModels{EmployeesViewModelFactory((activity as MainActivity).repository)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employees_fragment, container, false)
    }
}

@Suppress("UNCHECKED_CAST")
class EmployeesViewModelFactory(val repository: Repository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeesViewModel(repository) as T
    }
}