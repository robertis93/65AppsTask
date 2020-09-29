package com.example.testtask.ui.specialities


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.R
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.Repository
import com.example.testtask.ui.MainActivity
import com.example.testtask.utils.CharacterItemDecoration
import com.example.testtask.utils.TestTask
import kotlinx.android.synthetic.main.specialitites_fragment.*


class SpecialititesFragment : Fragment(),  SpeciliatiesAdapter.Listener  {
    val viewModel: SpecialititesViewModel by viewModels{SpecialititesViewModelFactory(TestTask.repository)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.specialitites_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_specialities.layoutManager = LinearLayoutManager(context)
        recycler_specialities.addItemDecoration(CharacterItemDecoration(50))
        viewModel.specialitiesLiveData.observe(viewLifecycleOwner, Observer { specialitiesList->
            val adapter = SpeciliatiesAdapter(specialitiesList, this)
            recycler_specialities.adapter = adapter

        })

    }


    override fun onItemClick(speciality: Speciality) {
        val action = SpecialititesFragmentDirections.actionSpecialititesFragmentToEmployeesFragment(speciality.id)
        findNavController().navigate(action)
    }
}

@Suppress("UNCHECKED_CAST")
class SpecialititesViewModelFactory(val repository: Repository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SpecialititesViewModel(repository) as T
    }
}


