package com.example.cosurf.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cosurf.Api.ApiService
import com.example.cosurf.Api.Constants
import com.example.cosurf.model.data.Fields
import com.example.cosurf.model.data.Photo
import com.example.cosurf.model.data.Record
import com.example.cosurf.model.data.Welcome
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun AddSpotForm(navController: NavController, onBackClicked: () -> Unit) {
    val surfbreak = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    val newSpot = Record( id = "",
                            fields = Fields(surfBreak = listOf(surfbreak.value) ,
                                address = address.value,
                                destination = "",
                                destinationStateCountry = "",
                                difficultyLevel = 0,
                                geocode = "",
                                influencers = listOf(""),
                                magicSeaweedLink = "", peakSurfSeasonBegins = "", peakSurfSeasonEnds = "", photos = listOf(),
                                )
                            ,createdTime = "")

    Column {
        ScaffoldSurf(
            title = "Ajouter un Spot",
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onIconClicked = onBackClicked
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedTextField(
                value = surfbreak.value,
                onValueChange = { surfbreak.value = it },
                label = { Text("SurfBreak") },
                modifier = Modifier.fillMaxWidth()
            )


            OutlinedTextField(
                value = address.value,
                onValueChange = { address.value = it },
                label = { Text("Adresse") },
                modifier = Modifier.fillMaxWidth()
            )


            Button(
                onClick = { addSurfSpot(newSpot) {
                    Log.d("it", "$it")
                }  },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Enregistrer")
            }
        }
    }

}
private fun addSurfSpot( spotData: Record, onResult: (Record?) -> Unit) {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()


    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    val apiService = retrofit.create(ApiService::class.java)

    val result = apiService.addSpot(spotData)
    Log.d("lol", "$result")
    Log.d("lul", "$spotData")
    result.enqueue(object : Callback<Record> {
        override fun onResponse(call: Call<Record>, response: Response<Record>) {

            if (response.isSuccessful) {
                val addedSpot = response.body()
                Log.d("tata", "${response.body()}")
                onResult(addedSpot)
            }
        }

        override fun onFailure(call: Call<Record>, t: Throwable) {
            Log.d("erreur", "$t")

        }
    })
}