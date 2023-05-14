package com.example.conversiondeunidadescompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conversiondeunidadescompose.data.Conversion
import com.example.conversiondeunidadescompose.data.ConversionResult
import com.example.conversiondeunidadescompose.data.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(private val repository: ConverterRepository): ViewModel() {
    fun getConversions() = listOf<Conversion>(
        Conversion(1, "Libras a Kilogramos", "lbs", "kg", 0.453592),
        Conversion(2, "Kilogramos a Libras", "kg", "lbs", 2.20462),
        Conversion(3, "Yardas a Metros", "yd", "m", 0.9144),
        Conversion(4, "Metros a Yardas", "m", "yd", 1.09361),
        Conversion(5, "Millas a Kilómetros", "mi", "km", 1.60934),
        Conversion(6, "Kilómetros a Millas", "km", "mi", 0.621371)
    )
    val resultList = repository.getSavedResults()
    fun addResult(message1 : String, message2 : String){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertResult(ConversionResult(0, message1, message2))
        }
    }
    fun removeResult(item: ConversionResult){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(result = item)
        }
    }
    fun clearAll(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllResults()
        }
    }
}