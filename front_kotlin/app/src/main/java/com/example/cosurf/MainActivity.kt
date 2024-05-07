package com.example.cosurf

import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cosurf.Api.ApiClient
import com.example.cosurf.Api.ApiService

import com.example.cosurf.ui.theme.CosurfTheme
import com.example.cosurf.view.AllSurfSpots
import com.example.cosurf.view.SpotItem
import kotlinx.coroutines.*

import com.example.cosurf.Api.Constants
import com.example.cosurf.model.data.Welcome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val apiService = retrofit.create(ApiService::class.java)

            val result = apiService.fetchSpots(token = "Bearer " + Constants.API_KEY)
            var surfSpot :Welcome?= Welcome(listOf())
            val surfSpotState = remember { mutableStateOf<Welcome?>(null) }
            Log.d("tata","hello $result")
            result.enqueue(object : Callback<Welcome>{
                override fun onResponse(p0: Call<Welcome>, p1: Response<Welcome>) {
                    Log.d("toto","coucou $p1")
                    if(p1.isSuccessful){
                        surfSpot = p1.body()
                        Log.d("lol","$surfSpot")


                    }
                }

                override fun onFailure(p0: Call<Welcome>, p1: Throwable) {
                    Toast.makeText(applicationContext,"erreur serveur", Toast.LENGTH_SHORT).show()
                }
            })

            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "allSpots") {
                composable("allSpots") {
                    CosurfTheme {
                        AllSurfSpots(navController = navController, welcome = surfSpot!!)
                    }
                }
                composable("spotItem/{spotId}") { backStackEntry ->
                    val spotId = backStackEntry.arguments?.getString("spotId")
                    val spot = surfSpot!!.records.firstOrNull() { it.id.toString() == spotId }
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




