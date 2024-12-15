package com.luisbaena.actividades_1_5.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luisbaena.actividades_1_5.ui.theme.Actividades_15Theme

/*
Actividad 4:
- Sitúa el TextField en el centro de la pantalla.
- Haz que reemplace el valor de una coma por un punto y que no deje escribir más de un punto decimal.
*/

@Composable
fun Actividad4Screen(modifier: Modifier = Modifier) {
    // Estado para almacenar el valor del TextField
    var myVal by rememberSaveable { mutableStateOf("") }

    // Contenedor principal que centra el TextField en la pantalla
    Column(
        modifier = modifier
            .fillMaxSize(), // Ocupa toda la pantalla
        verticalArrangement = Arrangement.Center, // Centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
    ) {
        // TextField con lógica de validación
        TextField(
            value = myVal,
            onValueChange = { input ->
                // Lógica para reemplazar comas por puntos y validar que no haya más de un punto
                val newValue = input
                    .replace(",", ".") // Reemplazar comas por puntos
                    .takeIf { it.count { char -> char == '.' } <= 1 } // Permitir solo un punto
                if (newValue != null) {
                    myVal = newValue
                }
            },
            label = { Text(text = "Importe") },
            modifier = Modifier.fillMaxWidth(0.8f) // Ancho del 80% de la pantalla
        )
    }
}

// Vista previa del diseño
@Preview(showBackground = true)
@Composable
fun Actividad4ScreenPreview() {
    Actividades_15Theme {
        Actividad4Screen()
    }
}
