package com.cdev.service.data.model

data class TvSeriesDetails(
    val id: Long,
    val name: String,
    val overview: String,
    val backgroundImage: String,
    val coverImage: String,
    val genres: List<Genre>,
    val airDate: String,
    val episodeDuration: Int,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val seasons: List<TvSeason>){

    private val rating: Int = -1
}