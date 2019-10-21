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

    get("/popular") {
        call.respond(apiGateway.getPopularContent())
    }
}