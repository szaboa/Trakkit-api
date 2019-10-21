package com.cdev.service.tmdb

import com.cdev.service.tmdb.model.TvSeries
import com.cdev.service.tmdb.model.TvSeriesResult
import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.call.receive
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.http.HttpMethod

class TmdbService {

    private val client = HttpClient() {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun getPopularContent(): ArrayList<TvSeries> {
        val call =
            client.call("https://api.themoviedb.org/3/tv/popular?api_key=df21461253277ed207247498065870cf&language=en-US&page=1") {
                method = HttpMethod.Get
            }

        val response = call.response.receive<TvSeriesResult>()

        val result = ArrayList<TvSeries>()
        for (tvSeries in response.result) {
            result.add(tvSeries)
        }

        return result
    }
}