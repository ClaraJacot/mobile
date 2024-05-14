package com.example.cosurf

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cosurf.Api.ApiService
import com.example.cosurf.Api.Constants
import com.example.cosurf.model.data.Welcome
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class SurfSpotViewModel : ViewModel() {
    private val _surfSpotState = mutableStateOf<Welcome?>(null)
    val surfSpotState: State<Welcome?> = _surfSpotState

    init {
        fetchSurfSpots()
    }

    private fun fetchSurfSpots() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)

        val result = apiService.fetchSpots()
        Log.d("lol", "$result")
        result.enqueue(object : Callback<Welcome> {
            override fun onResponse(call: Call<Welcome>, response: Response<Welcome>) {
                if (response.isSuccessful) {
                    _surfSpotState.value = response.body()
                }
            }

            override fun onFailure(call: Call<Welcome>, t: Throwable) {
                Log.d("erreur", "$t")

            }
        })
    }
}

