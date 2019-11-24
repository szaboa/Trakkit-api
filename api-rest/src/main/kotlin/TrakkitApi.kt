package com.cdev.api.rest

import com.cdev.api.gateway.ApiGateway
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.trakkitApi(apiGateway: ApiGateway) {
    get("/config-frontpage") {
        call.respond(apiGateway.getFrontPageConfig())
    }

    get("/category/{categoryId}") {
        val categoryId = call.parameters["categoryId"]
        call.respond(apiGateway.getCategory(categoryId))
    }

    get("/details/{id}") {
        val id = call.parameters["id"]
        call.respond(apiGateway.getTvSeries(id))
    }

    get("/details/{id}/{season_number}") {
        val id = call.parameters["id"]
        val seasonNumber = call.parameters["season_number"]
        call.respond(apiGateway.getTvSeason(id, seasonNumber))
    }
}