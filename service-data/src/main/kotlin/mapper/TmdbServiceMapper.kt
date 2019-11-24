package com.cdev.service.data.mapper

import com.cdev.service.data.model.*
import com.cdev.service.tmdb.model.TmdbGenre
import com.cdev.service.tmdb.model.TmdbTvEpisode
import com.cdev.service.tmdb.model.TmdbTvSeason
import com.cdev.service.tmdb.model.TmdbTvSeries

class TmdbServiceMapper {
    companion object {

        fun mapSeriesDetails(tmdbTvSeries: TmdbTvSeries): TvSeriesDetails {
            val episodeRunTime: Int = tmdbTvSeries.episodeRunTime?.get(0) ?: 0;

            return TvSeriesDetails(
                tmdbTvSeries.id ?: 0,
                tmdbTvSeries.name ?: "",
                tmdbTvSeries.overview ?: "",
                tmdbTvSeries.backdropPath ?: "",
                tmdbTvSeries.posterPath ?: "",
                mapGenreList(tmdbTvSeries.genres ?: ArrayList()),
                tmdbTvSeries.firstAirDate ?: "",
                episodeRunTime,
                tmdbTvSeries.numberOfEpisodes ?: 0,
                tmdbTvSeries.numberOfSeasons ?: 0,
                mapSeasonList(tmdbTvSeries.seasons ?: ArrayList())
            )
        }

        fun mapSeriesList(listOfTmdbTvSeries: List<TmdbTvSeries>): List<TvSeries> {
            val result = ArrayList<TvSeries>()
            for (tmdbTvSeries in listOfTmdbTvSeries) {
                result.add(mapSeries(tmdbTvSeries))
            }
            return result
        }

        fun mapSeason(tmdbTvSeason: TmdbTvSeason): TvSeason {
            return TvSeason(
                tmdbTvSeason.id ?: 0,
                tmdbTvSeason.name ?: "",
                tmdbTvSeason.seasonNumber ?: 0,
                mapEpisodeList(tmdbTvSeason.episodes ?: ArrayList())
            )
        }

        private fun mapSeries(tmdbTvSeries: TmdbTvSeries): TvSeries {
            return TvSeries(
                tmdbTvSeries.id ?: 0,
                tmdbTvSeries.name ?: "",
                tmdbTvSeries.backdropPath ?: "",
                tmdbTvSeries.posterPath ?: ""
            )
        }

        private fun mapGenre(tmdbGenre: TmdbGenre): Genre {
            return Genre(
                tmdbGenre.id ?: 0,
                tmdbGenre.name ?: ""
            )
        }

        private fun mapGenreList(tmdbGenres: List<TmdbGenre>): List<Genre> {
            val result = ArrayList<Genre>()
            for (tmdbGenre in tmdbGenres) {
                result.add(mapGenre(tmdbGenre))
            }
            return result
        }

        private fun mapSeasonList(tmdbTvSeasons: List<TmdbTvSeason>): List<TvSeason> {
            val result = ArrayList<TvSeason>()
            for (tmdbTvSeason in tmdbTvSeasons) {
                result.add(mapSeason(tmdbTvSeason))
            }
            return result
        }

        private fun mapEpisode(tmdbTvEpisode: TmdbTvEpisode): TvEpisode {
            return TvEpisode(
                tmdbTvEpisode.id ?: 0,
                tmdbTvEpisode.name ?: "",
                tmdbTvEpisode.stillPath ?: "",
                /* coverImage */"",
                tmdbTvEpisode.overview ?: "",
                tmdbTvEpisode.airDate ?: ""
            )
        }

        private fun mapEpisodeList(tmdbTvEpisodes: List<TmdbTvEpisode>): List<TvEpisode> {
            val result = ArrayList<TvEpisode>()
            for (tmdbTvEpisode in tmdbTvEpisodes) {
                result.add(mapEpisode(tmdbTvEpisode))
            }
            return result
        }
    }
}