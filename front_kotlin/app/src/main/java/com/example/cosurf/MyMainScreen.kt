package com.example.cosurf

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cosurf.model.data.Welcome
import com.example.cosurf.ui.theme.CosurfTheme
import com.example.cosurf.view.AllSurfSpots
import com.example.cosurf.view.SpotItem

@Composable
fun MyMainScreen(navController: NavHostController, surfSpotState: Welcome?) {
    NavHost(navController = navController, startDestination = "allSpots") {
        composable("allSpots") {
            CosurfTheme {
                surfSpotState?.let { surfSpot ->
                    AllSurfSpots(navController = navController, welcome = surfSpot)
                }
            }
        }
        composable("spotItem/{spotId}") { backStackEntry ->
            val spotId = backStackEntry.arguments?.getString("spotId")
            val surfSpot = surfSpotState?.records?.firstOrNull { it.id.toString() == spotId }
            surfSpot?.let { spot ->
                CosurfTheme {
                    SpotItem(
                        surfSpot = spot,
                        surfPhoto = spot.fields.photos[0],
                        onBackClicked = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}