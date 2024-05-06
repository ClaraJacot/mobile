package com.example.cosurf.model.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Welcome (
    val records: List<Record>,
    val offset: String
)

@Serializable
data class Record (
    val id: String,
    val fields: Fields,
    val createdTime: String
)

@Serializable
data class Fields (
    @SerialName("Surf Break")
    val surfBreak: List<String>,

    @SerialName("Difficulty Level")
    val difficultyLevel: Long,

    @SerialName("Destination")
    val destination: String,

    @SerialName("Geocode")
    val geocode: String,

    @SerialName("Influencers")
    val influencers: List<String>,

    @SerialName("Magic Seaweed Link")
    val magicSeaweedLink: String,

    @SerialName("Photos")
    val photos: List<Photo>,

    @SerialName("Peak Surf Season Begins")
    val peakSurfSeasonBegins: String,

    @SerialName("Destination State/Country")
    val destinationStateCountry: String,

    @SerialName("Peak Surf Season Ends")
    val peakSurfSeasonEnds: String,

    @SerialName("Address")
    val address: String
)

@Serializable
data class Photo (
    val id: String,
    val url: String,
    val filename: String,
    val size: Long,
    val type: String,
    val thumbnails: Thumbnails
)

@Serializable
data class Thumbnails (
    val small: Full,
    val large: Full,
    val full: Full
)

@Serializable
data class Full (
    val url: String,
    val width: Long,
    val height: Long
)


