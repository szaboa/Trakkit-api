package com.cdev.service.tmdb.model

import com.google.gson.annotations.SerializedName

data class TmdbTvSeason(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("season_number") val seasonNumber: Int?,
    @SerializedName("episodes") val episodes: List<TmdbTvEpisode>?
)