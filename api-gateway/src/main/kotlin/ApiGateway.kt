package com.cdev.api.gateway

import com.cdev.api.gateway.model.Response
import com.cdev.api.gateway.model.ResponseMessage
import com.cdev.service.config.ConfigService
import com.cdev.service.config.FrontPageConfig
import com.cdev.service.data.DataService
import com.cdev.service.data.model.TvSeason
import com.cdev.service.data.model.TvSeries
import com.cdev.service.data.model.TvSeriesDetails

class ApiGateway {
    private val configService: ConfigService = ConfigService()
    private val dataService: DataService = DataService()

    suspend fun getFrontPageConfig(): Response<List<FrontPageConfig>> {
        val config = configService.getConfig()
        return Response(true, "Front page category", config)
    }

    suspend fun getCategory(categoryId: String?): Response<List<TvSeries>> {
        if (categoryId == null) {
            return Response(false, ResponseMessage.INVALID_PARAM, ArrayList())
        }

        val category = dataService.getCategory(categoryId)
        val success: Boolean = !category.isNullOrEmpty()
        val message = if (success) "Category found" else "Category not found"
        return Response(success, message, category)
    }

    suspend fun getTvSeries(id: String?): Response<TvSeriesDetails?> {
        if (id == null || id.toIntOrNull() == null) {
            return Response(false, ResponseMessage.INVALID_PARAM, null)
        }

        val series = dataService.getTvSeries(id)
        val success: Boolean = series != null
        val message = if (success) "TV series found" else "TV series not found"
        return Response(success, message, series)
    }

    suspend fun getTvSeason(id: String?, seasonNumber: String?): Response<TvSeason?> {
        if (id == null || id.toIntOrNull() == null || seasonNumber == null || seasonNumber.toIntOrNull() == null) {
            return Response(false, ResponseMessage.INVALID_PARAM, null)
        }

        val season = dataService.getTvSeason(id, seasonNumber)
        val success: Boolean = season != null
        val message = if (success) "TV Season found" else "TV Season not found"
        return Response(success, message, season)
    }
}