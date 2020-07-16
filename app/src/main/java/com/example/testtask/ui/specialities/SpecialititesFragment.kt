package com.example.testtask.ui.specialities

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testtask.R
import com.example.testtask.data_source.Repository
import com.example.testtask.ui.MainActivity

class SpecialititesFragment : Fragment() {
    val viewModel: SpecialititesViewModel by viewModels{SpecialititesViewModelFactory((activity as MainActivity).repository)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.specialitites_fragment, container, false)
    }

    fun onClickSpecialityItem(specialityId: Int){
        val action = SpecialititesFragmentDirections.actionSpecialititesFragmentToEmployeesFragment(specialityId)
        findNavController().navigate(action)
    }
}

@Suppress("UNCHECKED_CAST")
class SpecialititesViewModelFactory(val repository: Repository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SpecialititesViewModel(repository) as T
    }
}