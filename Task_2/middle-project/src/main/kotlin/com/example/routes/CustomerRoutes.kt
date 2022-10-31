package com.example.routes

import com.example.dbconnection.dao
import com.example.models.Customer
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.customerRouting() {
    route("/customer") {
        get {
            call.respond(dao.allCustomers())
        }

        post {
            val customer = call.receive<Customer>()
           println(customer.toString())
            dao.addNewCustomer(customer.id, customer.firstName, customer.lastName, customer.email)
            call.respond(customer)
        }
    }

//        get("{id?}") {
//            val id = call.parameters["id"] ?: return@get call.respondText(
//                "Missing id",
//                status = HttpStatusCode.BadRequest
//            )
//            val customer =
//                customerStorage.find { it.id == id } ?: return@get call.respondText(
//                    "No customer with id $id",
//                    status = HttpStatusCode.NotFound
//                )
//            call.respond(customer)
//        }
//
//        post {
//                val customer = call.receive<Customer>()
//                customerStorage.add(customer)
//                call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
//        }
//
//        delete("{id?}") {
//            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
//            if (customerStorage.removeIf { it.id == id }) {
//                call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
//            } else {
//                call.respondText("Not Found", status = HttpStatusCode.NotFound)
//            }
//        }
    }