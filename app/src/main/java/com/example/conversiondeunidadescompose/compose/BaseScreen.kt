package com.example.conversiondeunidadescompose.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.conversiondeunidadescompose.ConverterViewModel
import com.example.conversiondeunidadescompose.ConverterViewModelFactory
import com.example.conversiondeunidadescompose.compose.converter.TopScreen
import com.example.conversiondeunidadescompose.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory),
) {
    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())
    Column(
        modifier = modifier
            .padding(30.dp)
            .fillMaxSize()
    ) {
        TopScreen(list)
        { message1, message2 ->
            converterViewModel.addResult(message1, message2)
        }
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen(
            historyList,
            {
                converterViewModel.clearAll()
            }, { item ->
                converterViewModel.removeResult(item)
            })
    }
}