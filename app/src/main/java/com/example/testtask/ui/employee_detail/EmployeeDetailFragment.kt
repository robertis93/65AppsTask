package com.example.testtask.ui.employee_detail



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.testtask.R
import com.example.testtask.data_source.Repository
import com.example.testtask.TestTaskApp
import com.example.testtask.databinding.EmployeeDetailFragmentBinding
import kotlinx.android.synthetic.main.employee_detail_fragment.*
import kotlinx.coroutines.launch


class EmployeeDetailFragment() : Fragment() {
    val viewModel: EmployeeDetailViewModel by viewModels{EmployeeDetailViewModelFactory(TestTaskApp.repository)}
    val args: EmployeeDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = EmployeeDetailFragmentBinding.inflate(inflater, container, false)
        viewModel.employeeId = args.employeeId
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }
}

@Suppress("UNCHECKED_CAST")
class EmployeeDetailViewModelFactory(val repository: Repository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeDetailViewModel(repository) as T
    }
}