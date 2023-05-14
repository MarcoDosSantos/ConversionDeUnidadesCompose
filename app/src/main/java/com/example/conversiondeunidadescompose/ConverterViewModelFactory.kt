package com.example.conversiondeunidadescompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.conversiondeunidadescompose.data.ConverterRepository

/*Debe tener el mismo parámetro de entrada del constructor que el ViewModel.
* Debe extender de ViewModelProvider.NewInstanceFactory*/
class ConverterViewModelFactory (private val repository: ConverterRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ConverterViewModel(repository) as T
}