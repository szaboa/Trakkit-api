package com.cdev.service.tmdb.model

import com.google.gson.annotations.SerializedName

data class TmdbTvEpisode(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("episode_number") val episodeNumber: Int?,
    @SerializedName("season_number") val seasonNumber: Int?,
    @SerializedName("air_date") val airDate: String?,
    @SerializedName("still_path") val stillPath: String?
)