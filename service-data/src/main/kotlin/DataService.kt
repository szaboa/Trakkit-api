package com.cdev.service.data

import com.cdev.service.data.mapper.TmdbServiceMapper
import com.cdev.service.data.model.TvSeason
import com.cdev.service.data.model.TvSeries
import com.cdev.service.data.model.TvSeriesDetails
import com.cdev.service.tmdb.TmdbService

class DataService() {

    private val tmdbService: TmdbService = TmdbService()

    suspend fun getCategory(categoryId: String): List<TvSeries> {
        return when (categoryId) {
            "1000" -> ArrayList()// TODO implement Continue watching
            "1001" -> TmdbServiceMapper.mapSeriesList(tmdbService.getOnTheAir())
            "1002" -> TmdbServiceMapper.mapSeriesList(tmdbService.getAiringToday())
            "1003" -> TmdbServiceMapper.mapSeriesList(tmdbService.getPopular())
            "1004" -> TmdbServiceMapper.mapSeriesList(tmdbService.getTopRated())
            else -> ArrayList()
        }
    }

    suspend fun getTvSeries(id: String): TvSeriesDetails? {
        val series = tmdbService.getTvSeriesDetails(id.toInt()) ?: return null
        return TmdbServiceMapper.mapSeriesDetails(series)
    }

    suspend fun getTvSeason(id: String, seasonNumber: String): TvSeason? {
        val details = tmdbService.getTvSeason(id.toInt(), seasonNumber.toInt()) ?: return null
        return TmdbServiceMapper.mapSeason(details)
    }

    suspend fun search(query: String) : List<TvSeries>{
        val seriesList = tmdbService.search(query)
        return TmdbServiceMapper.mapSeriesList(seriesList)
    }
}