package com.luisbaena.actividades_1_5.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luisbaena.actividades_1_5.ui.theme.Actividades_15Theme

/*
Actividad 5:
Haz lo mismo, pero elevando el estado a una función superior y usando un componente OutlinedTextField
al que debes añadir un padding alrededor de 15 dp y establecer colores diferentes en los bordes
cuando tenga el foco y no lo tenga.
A nivel funcional no permitas que se introduzcan caracteres que invaliden un número decimal.
*/

@Composable
fun Actividad5Screen(modifier: Modifier = Modifier) {
    var myVal by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DecimalInputField(
            value = myVal,
            onValueChange = { myVal = it }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DecimalInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = { input ->
            val newValue = input
                .replace(",", ".")
                .takeIf { it.matches(Regex("^\\d*\\.?\\d*\$")) }
            if (newValue != null) {
                onValueChange(newValue)
            }
        },
        label = { Text(text = "Importe") },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        modifier = modifier
            .fillMaxWidth(0.8f)
            .padding(15.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Gray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun Actividad5ScreenPreview() {
    Actividades_15Theme {
        Actividad5Screen()
    }
}