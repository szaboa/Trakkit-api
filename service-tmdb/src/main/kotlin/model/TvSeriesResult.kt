package com.cdev.service.tmdb.model

import com.google.gson.annotations.SerializedName

data class TvSeriesResult(
    @SerializedName("results") val result: ArrayList<TvSeries>?
)