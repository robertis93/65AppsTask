package com.example.testtask.ui.specialities


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.R
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.Repository
import com.example.testtask.utils.CharacterItemDecoration
import com.example.testtask.TestTaskApp
import kotlinx.android.synthetic.main.specialitites_fragment.*
import kotlinx.coroutines.launch


class SpecialititesFragment : Fragment(), SpeciliatiesAdapter.Listener {
    val viewModel: SpecialititesViewModel by viewModels { SpecialititesViewModelFactory(TestTaskApp.repository) }
    lateinit var specialities: List<Speciality>
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
        lifecycleScope.launch {
            try {
                val specialities = viewModel.getSpecialities()
                val adapter = SpeciliatiesAdapter(specialities, this@SpecialititesFragment)
                recycler_specialities.adapter = adapter
            } catch (e: Exception) {
                Toast.makeText(context, "Ошибка. Нет доступа к серверу", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onItemClick(speciality: Speciality) {
        val action = SpecialititesFragmentDirections.actionSpecialititesFragmentToEmployeesFragment(
            speciality.id
        )
        findNavController().navigate(action)
    }
}

@Suppress("UNCHECKED_CAST")
class SpecialititesViewModelFactory(val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SpecialititesViewModel(repository) as T
    }
}


