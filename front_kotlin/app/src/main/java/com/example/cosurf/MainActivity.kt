package com.example.cosurf

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cosurf.model.data.Welcome
import com.example.cosurf.model.jsonSurf
import com.example.cosurf.ui.theme.CosurfTheme
import com.example.cosurf.view.AllSurfSpots
import com.example.cosurf.view.SpotItem
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val surfSpot = Json.decodeFromString<Welcome>(jsonSurf)
            Log.d("toto", "$jsonSurf")
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "allSpots") {
                composable("allSpots") {
                    CosurfTheme {
                        AllSurfSpots(navController = navController, welcome = surfSpot)
                    }
                }
                composable("spotItem/{spotId}") { backStackEntry ->
                    val spotId = backStackEntry.arguments?.getString("spotId")
                    val spot = surfSpot.records.firstOrNull() { it.id.toString() == spotId }
                    spot?.let { spot ->
                        CosurfTheme {
                            SpotItem(surfSpot = spot,
                                onBackClicked = {
                                navController.popBackStack()
                            })
                        }
                    }
                }
            }
        }
    }
}




