package com.example.cosurf.Api

import com.example.cosurf.model.data.Welcome
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.BASE_URL)
    fun fetchSpots(@Header("Authorization") token: String): Call<Welcome>
}