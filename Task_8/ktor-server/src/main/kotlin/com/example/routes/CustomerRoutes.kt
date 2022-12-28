package com.example.routes

import com.example.models.Customer
import com.example.models.LoginAttempt
import com.example.models.customerMemory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {
    route("/login") {
        post {
            val approach = call.receive<LoginAttempt>()

            val user = approach.username
            val pass = approach.password

            var found = false

            for (customer in customerMemory) {
                if (user == customer.username && pass == customer.password) {
                    call.respond<Customer>(customer)
                    found = true
                    break

                }
            }

            if (!found) {
                call.respond(HttpStatusCode.NotFound, "not found")
            }


        }
    }
}