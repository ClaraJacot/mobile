package com.example.cosurf.Api

import com.example.cosurf.model.data.Record
import com.example.cosurf.model.data.Welcome
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.BASE_URL)
    fun fetchSpots(): Call<Welcome>


    //@Headers("Content-Type: application/json")
    @POST(Constants.BASE_URL)
    fun addSpot(@Body spotData: Record): Call<Record>

}