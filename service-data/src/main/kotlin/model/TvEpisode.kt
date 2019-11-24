package com.cdev.service.data.model

data class TvEpisode(
    val id: Long,
    val name: String,
    val backgroundImage: String,
    val coverImage: String,
    val overview: String,
    val airDate: String) {

    private val watched: Boolean = false
}