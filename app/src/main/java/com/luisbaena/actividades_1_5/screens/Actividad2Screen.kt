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
Actividad 2:
Modifica ahora también que se separe el botón de la línea de progreso 30 dp,
pero usando un estado... es decir, cuando no sea visible no quiero que tenga la separación
aunque no se vea.
*/

@Composable
fun Actividad2Screen(modifier: Modifier = Modifier) {
    // Variable de estado para controlar si se muestra la animación de carga
    var showLoading by rememberSaveable { mutableStateOf(false) }

    // Determinar el espaciado dinámicamente según el estado
    val buttonTopPadding = if (showLoading) 30.dp else 0.dp

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

        // Botón con espaciado dinámico controlado por el estado
        Spacer(modifier = Modifier.height(buttonTopPadding)) // Separación dinámica
        Button(
            onClick = { showLoading = !showLoading }
        ) {
            Text(text = if (showLoading) "Cancelar" else "Cargar perfil")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Actividad2ScreenPreview() {
    Actividades_15Theme {
        Actividad2Screen()
    }
}
