package com.cdev.api.gateway

import com.cdev.service.config.ConfigService
import com.cdev.service.config.FrontPageConfig
import com.cdev.service.tmdb.TmdbService
import com.cdev.service.tmdb.model.TvSeries

class ApiGateway {
    private val configService: ConfigService = ConfigService()
    private val tmdbService: TmdbService = TmdbService()

    suspend fun getFrontPageConfig(): FrontPageConfig {
        return configService.getConfig()
    }

    suspend fun getPopularContent(): ArrayList<TvSeries>{
        return tmdbService.getPopularContent()
    }
}