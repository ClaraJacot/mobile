package com.example.cosurf.model.data

import com.example.cosurf.model.jsonSurf
import com.example.cosurf.model.surfspots
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Records (
    @SerialName("records")
    val records : List<SurfSpot>
)

@Serializable
data class SurfSpot(
    val id : String,
    @SerialName ("Surf Break")
    val name: String,
    @SerialName("Address")
    val address: String,
    @SerialName("Photos")
    val picture : String)

fun json() {
    val surfSpot = Json.decodeFromString<SurfSpot>(jsonSurf)
}


