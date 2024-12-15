package com.luisbaena.actividades_1_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.luisbaena.actividades_1_5.screens.Actividad1Screen
import com.luisbaena.actividades_1_5.screens.Actividad2Screen
import com.luisbaena.actividades_1_5.screens.Actividad3Screen
import com.luisbaena.actividades_1_5.screens.Actividad4Screen
import com.luisbaena.actividades_1_5.screens.Actividad5Screen
import com.luisbaena.actividades_1_5.ui.theme.Actividades_15Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividades_15Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Actividad1Screen(modifier = Modifier.padding(innerPadding))
                    //Actividad2Screen(modifier = Modifier.padding(innerPadding))
                    //Actividad3Screen(modifier = Modifier.padding(innerPadding))
                    //Actividad4Screen(modifier = Modifier.padding(innerPadding))
                    Actividad5Screen(modifier = Modifier.padding(innerPadding))


                }
            }
        }
    }
}
