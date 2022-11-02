package com.example.routes

import com.example.dbconnection.dao
import com.example.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.countryRouting() {
    route("/country") {
        get {
            call.respond(dao.allCountries())
        }

        get("{id?}") {
            val name = call.parameters["name"] ?: return@get call.respondText(
                "Missing country's name",
                status = HttpStatusCode.BadRequest
            )

            call.respond(dao.country(name).toString())
        }
        post {
            val country = call.receive<Country>()
            dao.addNewCountry(country.name, country.distance, country.president, country.surface)
            call.respond(country)
        }

        put {
            val country = call.receive<Country>()
            dao.editCountry(country.name, country.distance, country.president, country.surface)
            call.respond(country)
        }

        delete("{name?}") {
            val name = call.parameters["name"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            dao.deleteCountry(name)
            call.respond(HttpStatusCode.OK)
        }
    }

}