package com.cdev.service.tmdb.model

import com.google.gson.annotations.SerializedName

data class TmdbTvSeries(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("first_air_date") val firstAirDate: String?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("genres") val genres: List<TmdbGenre>?,
    @SerializedName("episode_run_time") val episodeRunTime: List<Int>?,
    @SerializedName("number_of_episodes") val numberOfEpisodes: Int?,
    @SerializedName("number_of_seasons") val numberOfSeasons: Int?,
    @SerializedName("seasons") val seasons: List<TmdbTvSeason>?
)