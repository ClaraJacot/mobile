package com.example.cosurf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cosurf.model.surfspots
import com.example.cosurf.ui.theme.CosurfTheme
import com.example.cosurf.view.AllSurfSpots
import com.example.cosurf.view.ScaffoldSurf
import com.example.cosurf.view.SpotItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "allSpots") {
                composable("allSpots") {
                    CosurfTheme {
                        AllSurfSpots(navController = navController, platList = surfspots)
                    }
                }
                composable("spotItem/{spotId}") { backStackEntry ->
                    val spotId = backStackEntry.arguments?.getString("spotId")
                    val spot = surfspots.firstOrNull { it.id.toString() == spotId }
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




