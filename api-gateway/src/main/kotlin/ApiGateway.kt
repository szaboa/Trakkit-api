package com.cdev.api.gateway

import com.cdev.api.gateway.model.Response
import com.cdev.service.config.ConfigService
import com.cdev.service.config.FrontPageConfig
import com.cdev.service.tmdb.TmdbService
import com.cdev.service.tmdb.model.TvSeries

class ApiGateway {
    private val configService: ConfigService = ConfigService()
    private val tmdbService: TmdbService = TmdbService()

    suspend fun getFrontPageConfig(): Response<List<FrontPageConfig>> {
        val config = configService.getConfig()
        return Response(true, "Front page category", config)
    }

    suspend fun getCategory(categoryId: String?): Response<List<TvSeries>> {
        val category = tmdbService.getCategory(categoryId)
        val success: Boolean = !category.isNullOrEmpty()
        val message = if (success) "Category found" else "Category not found"
        return Response(success, message, category)
    }
}