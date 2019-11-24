package com.cdev.service.data.model

data class TvSeason(
    val id: Long,
    val name: String,
    val seasonNumber: Int,
    val episodesList: List<TvEpisode>) {

    private val numberOfWatchedEpisodes: Int = 0;
}