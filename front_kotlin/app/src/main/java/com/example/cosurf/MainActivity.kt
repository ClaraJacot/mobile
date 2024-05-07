package com.example.cosurf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: SurfSpotViewModel = viewModel()

            val surfSpotState by viewModel.surfSpotState

            val navController = rememberNavController()

            MyMainScreen(navController = navController, surfSpotState = surfSpotState)
        }
    }
}







