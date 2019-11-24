package com.cdev.service.tmdb.model

import com.google.gson.annotations.SerializedName

data class TmdbTvSeriesResult(
    @SerializedName("results") val result: ArrayList<TmdbTvSeries>?
)