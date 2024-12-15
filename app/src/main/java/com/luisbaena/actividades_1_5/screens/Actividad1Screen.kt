package com.luisbaena.actividades_1_5.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luisbaena.actividades_1_5.ui.theme.Actividades_15Theme

/*
Actividad 1:
Hacer que el texto del botón muestre "Cargar perfil", pero cambie a "Cancelar"
cuando se muestre la línea de progreso... Cuando pulsemos "Cancelar" vuelve al texto por defecto.
*/

@Composable
fun Actividad1Screen(modifier: Modifier = Modifier) {
    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Si `showLoading` es verdadero, se muestran los indicadores de carga
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 10.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.LightGray
            )
        }

        // Botón que alterna entre los estados de carga y normal
        Button(
            onClick = { showLoading = !showLoading }
        ) {
            Text(text = if (showLoading) "Cancelar" else "Cargar perfil")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Actividad1ScreenPreview() {
    Actividades_15Theme {
        Actividad1Screen()
    }
}
