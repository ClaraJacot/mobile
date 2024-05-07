package com.example.cosurf.model.data


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class Welcome (
    var records: List<Record>
)

@Serializable
data class Record (
    var id: String,
    var fields: Fields,
    var createdTime: String
)

@Serializable
data class Fields (
    @SerializedName("Surf Break")
    var surfBreak: List<String>,

    @SerializedName("Difficulty Level")
    var difficultyLevel: Long,

    @SerializedName("Destination")
    var destination: String,

    @SerializedName("Geocode")
    var geocode: String,

    @SerializedName("Influencers")
    var influencers: List<String>,

    @SerializedName("Magic Seaweed Link")
    var magicSeaweedLink: String,

    @SerializedName("Photos")
    var photos: List<Photo>,

    @SerializedName("Peak Surf Season Begins")
    var peakSurfSeasonBegins: String,

    @SerializedName("Destination State/Country")
    var destinationStateCountry: String,

    @SerializedName("Peak Surf Season Ends")
    var peakSurfSeasonEnds: String,

    @SerializedName("Address")
    var address: String
)

@Serializable
data class Photo (
    var id: String,
    var url: String,
    var filename: String,
    var size: Long,
    var type: String,
    var thumbnails: Thumbnails
)

@Serializable
data class Thumbnails (
    var small: Full,
    var large: Full,
    var full: Full
)

@Serializable
data class Full (
    var url: String,
    var width: Long,
    var height: Long
)


