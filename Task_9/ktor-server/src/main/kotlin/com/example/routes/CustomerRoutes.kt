package com.example.routes

import com.example.models.PayAttempt
import com.example.models.Response
import com.example.models.customerMemory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {
    route("/pay") {
        post {
            val approach = call.receive<PayAttempt>()

            val card = approach.card_number
            val cvc = approach.CVC
            val date = approach.date

            var found = false

            for (customer in customerMemory) {
                if ((card == customer.card_number) && (cvc == customer.CVC) && date == customer.date) {
                    call.respond<Response>(Response("OK"))
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