package com.cdev.service.tmdb.model

import com.google.gson.annotations.SerializedName

data class TmdbGenre(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?
)