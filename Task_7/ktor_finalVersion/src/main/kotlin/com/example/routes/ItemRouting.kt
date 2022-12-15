package com.example.routes

import com.example.model.itemList
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.itemRouting() {
    route("/items") {
        get {
            call.respond(itemList)
        }
    }
}