package com.cdev.service.tmdb

import com.cdev.service.tmdb.model.TmdbTvSeason
import com.cdev.service.tmdb.model.TmdbTvSeries
import com.cdev.service.tmdb.model.TmdbTvSeriesResult
import io.ktor.client.HttpClient
import io.ktor.client.call.HttpClientCall
import io.ktor.client.call.call
import io.ktor.client.call.receive
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

/**
 * Service that fetches data from TMDB.
 * See https://www.themoviedb.org.
 */
class TmdbService {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3"
        const val API_KEY = "df21461253277ed207247498065870cf"
    }

    private val client = HttpClient() {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun getPopular(): ArrayList<TmdbTvSeries> {
        val result = ArrayList<TmdbTvSeries>()
        val call = client.get("/tv/popular")
        val response = call.response.receive<TmdbTvSeriesResult>()

        // TODO add ext func for this
        response.result?.let {
            for (tvSeries in it) {
                result.add(tvSeries)
            }
        }

        return result
    }

    suspend fun getOnTheAir(): ArrayList<TmdbTvSeries> {
        val result = ArrayList<TmdbTvSeries>()
        val call = client.get("/tv/on_the_air")
        val response = call.response.receive<TmdbTvSeriesResult>()

        response.result?.let {
            for (tvSeries in it) {
                result.add(tvSeries)
            }
        }

        return result
    }

    suspend fun getAiringToday(): ArrayList<TmdbTvSeries> {
        val result = ArrayList<TmdbTvSeries>()
        val call = client.get("/tv/airing_today")
        val response = call.response.receive<TmdbTvSeriesResult>()

        response.result?.let {
            for (tvSeries in it) {
                result.add(tvSeries)
            }
        }

        return result
    }

    suspend fun getTopRated(): ArrayList<TmdbTvSeries> {
        val result = ArrayList<TmdbTvSeries>()
        val call = client.get("/tv/top_rated")
        val response = call.response.receive<TmdbTvSeriesResult>()

        response.result?.let {
            for (tvSeries in it) {
                result.add(tvSeries)
            }
        }

        return result
    }

    suspend fun getTvSeriesDetails(id: Int): TmdbTvSeries? {
        val call = client.get("/tv/$id")
        return try {
            call.response.receive<TmdbTvSeries>()
        } catch (e: ClientRequestException) {
            // Not found
            null
        }
    }

    suspend fun getTvSeason(id: Int, seasonNumber: Int): TmdbTvSeason? {
        val call = client.get("/tv/$id/season/$seasonNumber")
        return try {
            call.response.receive<TmdbTvSeason>()
        } catch (e: ClientRequestException) {
            // Not found
            null
        }
    }

    suspend fun search(query: String): List<TmdbTvSeries> {
        val queryMap: HashMap<String, String> = HashMap()
        queryMap["query"] = query

        val result = ArrayList<TmdbTvSeries>()
        val call = client.get("/search/tv", queryMap)
        return try {
            val response = call.receive<TmdbTvSeriesResult>()
            response.result?.let {
                for (tvSeries in it) {
                    result.add(tvSeries)
                }
            }
            result
        } catch (e: ClientRequestException) {
            result
        }
    }

    /**
     * Extension function that appends the api key for a GET request.
     */
    suspend fun HttpClient.get(url: String, queryParam: HashMap<String, String> = HashMap()): HttpClientCall {
        return client.call(BASE_URL + url) {
            method = HttpMethod.Get
            parameter("api_key", API_KEY)

            for ((k, v) in queryParam) {
                parameter(k, v)
            }
        }
    }
}