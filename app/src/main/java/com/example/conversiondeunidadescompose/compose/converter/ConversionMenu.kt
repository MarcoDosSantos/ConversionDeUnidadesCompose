package com.example.conversiondeunidadescompose.compose.converter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.conversiondeunidadescompose.data.Conversion

@Composable
fun ConversionMenu(list: List<Conversion>, modifier: Modifier = Modifier,
                   convert : (Conversion) -> Unit){
    var displayingText: String by remember {
        mutableStateOf("Elegí el tipo de conversión")
    }
    var textFieldSize by remember{ mutableStateOf(Size.Zero) }//Para asignar al menu dropdown la misma anchura que el textfield
    var expanded by remember {
        mutableStateOf(false)
    }
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }
    Column {
        OutlinedTextField(
            value = displayingText,
            onValueChange = { displayingText = it},//Va a tomar el texto del elemento seleccionado por el usuario (it),
            textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize =
                        coordinates.size.toSize()//Para asignar al menu dropdown la misma anchura que el textfield
                },
            label = { Text(text = "Tipo de conversión") },
            trailingIcon = {
                Icon(imageVector = icon, contentDescription = "icon",
                    modifier.clickable{ expanded = !expanded })

            },
            readOnly = true
        )

        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier
                .width(with(LocalDensity.current) {textFieldSize.width.toDp()}))
        {
            list.forEach {conversion ->
                DropdownMenuItem(onClick = {
                    displayingText = conversion.description
                    expanded = false
                    convert(conversion)
                }) {
                    Text(text = conversion.description,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}