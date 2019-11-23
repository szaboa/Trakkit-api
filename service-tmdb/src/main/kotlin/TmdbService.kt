package com.cdev.service.tmdb

import com.cdev.service.tmdb.model.TvSeries
import com.cdev.service.tmdb.model.TvSeriesResult
import io.ktor.client.HttpClient
import io.ktor.client.call.HttpClientCall
import io.ktor.client.call.call
import io.ktor.client.call.receive
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

class TmdbService {

    companion object{
        val API_KEY = "df21461253277ed207247498065870cf"
    }

    private val client = HttpClient() {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun getPopularContent(): ArrayList<TvSeries> {

        val call = client.get("/popular")
        val response = call.response.receive<TvSeriesResult>()
        val result = ArrayList<TvSeries>()
        for (tvSeries in response.result) {
            result.add(tvSeries)
        }

        return result
    }

    suspend fun HttpClient.get(url: String) : HttpClientCall{
        return client.call("https://api.themoviedb.org/3/tv$url") {
            method = HttpMethod.Get
            parameter("api_key", API_KEY)
        }
    }
}