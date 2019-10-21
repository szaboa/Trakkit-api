package com.cdev.service.tmdb.model

import com.google.gson.annotations.SerializedName

data class TvSeries(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("first_air_date") val firstAirDate: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("poster_path") val posterPath: String
)