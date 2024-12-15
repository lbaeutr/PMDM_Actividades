package com.luisbaena.actividades_1_5.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luisbaena.actividades_1_5.ui.theme.Actividades_15Theme

/*
Actividad 3:
- Separar los botones entre ellos 10 dp, del indicador de progreso 15 dp y centrarlos horizontalmente.
- Cuando se clique el botón Incrementar, debe añadir 0.1 a la propiedad progress y quitar 0.1
  cuando se pulse el botón Decrementar.
- Evitar que nos pasemos de los márgenes de su propiedad progressStatus (0-1).
*/

@Composable
fun Actividad3Screen(modifier: Modifier = Modifier) {
    // Estado para controlar el progreso
    var progress by rememberSaveable { mutableStateOf(0f) }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Indicador de progreso con separación de 15 dp
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth(0.8f) // Ocupa el 80% del ancho de la pantalla
                .padding(bottom = 15.dp),
        )

        // Fila para los botones
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (progress < 1f) progress += 0.1f // Incrementa el progreso sin pasar de 1
                },
                modifier = Modifier.padding(end = 10.dp) // Separación entre botones
            ) {
                Text(text = "Incrementar")
            }

            Button(
                onClick = {
                    if (progress > 0f) progress -= 0.1f // Reduce el progreso sin bajar de 0
                }
            ) {
                Text(text = "Reducir")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Actividad3ScreenPreview() {
    Actividades_15Theme {
        Actividad3Screen()
    }
}
