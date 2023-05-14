package com.example.conversiondeunidadescompose.compose.history

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.conversiondeunidadescompose.data.ConversionResult

@Composable
fun HistoryScreen(
    list: State<List<ConversionResult>>,
    onClearAllTask: () -> Unit,
    onCloseTask: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {
    Column() {
        /*Agregamos un if para que la Row se dibuje sólo si la lista no está vacía; es decir,
        * si al menos contiene un registro*/
        if ((list.value).isNotEmpty()) {

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Historial",
                    color = Color.Gray,
                )
                OutlinedButton(onClick = { onClearAllTask() }) {
                    Text(
                        text = "Borrar todo",
                        color = Color.Gray
                    )
                }
            }
        }
        HistoryList(list = list,
            onCloseTask = { item ->
                onCloseTask(item)
            })
    }

}