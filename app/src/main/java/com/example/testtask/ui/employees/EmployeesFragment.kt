package com.example.testtask.ui.employees



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.R
import com.example.testtask.data.Employee
import com.example.testtask.data_source.Repository
import com.example.testtask.ui.MainActivity
import com.example.testtask.utils.CharacterItemDecoration
import com.example.testtask.utils.TestTask
import kotlinx.android.synthetic.main.employees_fragment.*
import kotlinx.android.synthetic.main.specialitites_fragment.*


class EmployeesFragment : androidx.fragment.app.Fragment(), EmployeesAdapter.Listener {
    val viewModel: EmployeesViewModel by viewModels{EmployeesViewModelFactory(TestTask.repository)}
    val args: EmployeesFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.initSpecialityId(args.specialityId)
        return inflater.inflate(R.layout.employees_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_employees.addItemDecoration(CharacterItemDecoration(50))
        recycler_employees.layoutManager = LinearLayoutManager(context)
        viewModel.employeesLiveData.observe(viewLifecycleOwner, Observer<List<Employee>> { employeesList->
            val adapter = EmployeesAdapter(employeesList, this)
            recycler_employees.adapter = adapter
    })
    }

    override fun onItemClick(employee: Employee) {
        val action = EmployeesFragmentDirections.actionEmployeesFragmentToEmployeeDetailFragment(employee.id)
        findNavController().navigate(action)
    }
}

@Suppress("UNCHECKED_CAST")
class EmployeesViewModelFactory(val repository: Repository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeesViewModel(repository) as T
    }
}