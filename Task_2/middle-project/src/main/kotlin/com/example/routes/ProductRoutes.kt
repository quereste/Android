package com.example.routes

import com.example.dbconnection.dao
import com.example.models.Customer
import com.example.models.Product
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.productRouting() {
    route("/product") {
        get {
            call.respond(dao.allProducts())
        }

        post {
            val product = call.receive<Product>()
            dao.addNewProduct(product.id, product.name, product.mass, product.country)
            call.respond(product)
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