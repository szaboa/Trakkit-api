package com.cdev.service.tmdb

import com.cdev.service.tmdb.model.TvSeries
import com.cdev.service.tmdb.model.TvSeriesResult
import io.ktor.client.HttpClient
import io.ktor.client.call.HttpClientCall
import io.ktor.client.call.call
import io.ktor.client.call.receive
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
        const val BASE_URL = "https://api.themoviedb.org/3/tv"
        const val API_KEY = "df21461253277ed207247498065870cf"
    }

    private val client = HttpClient() {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun getCategory(categoryId: String?): ArrayList<TvSeries> {
        val result = ArrayList<TvSeries>()

        val url = TmdbCategoryMapper.map(categoryId) ?: return result
        val call = client.get(url)
        val response = call.response.receive<TvSeriesResult>()

        response.result?.let {
            for (tvSeries in it) {
                result.add(tvSeries)
            }
        }

        return result
    }

    /**
     * Extension function that appends the api key for a GET request.
     */
    suspend fun HttpClient.get(url: String): HttpClientCall {
        return client.call(BASE_URL + url) {
            method = HttpMethod.Get
            parameter("api_key", API_KEY)
        }
    }
}