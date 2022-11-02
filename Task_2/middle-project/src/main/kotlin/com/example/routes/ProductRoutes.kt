package com.example.routes

import com.example.dbconnection.dao
import com.example.models.Country
import com.example.models.Customer
import com.example.models.Product
import com.example.models.Products
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.jetbrains.exposed.sql.select

fun Route.productRouting() {
    route("/product") {
        get {
            call.respond(dao.allProducts())
        }

        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )

            call.respond(dao.product(id.toInt()).toString())
        }
        post {
            val product = call.receive<Product>()
            dao.addNewProduct(product.id, product.name, product.mass, product.country)
            call.respond(product)
        }

        put {
            val product = call.receive<Product>()
            dao.editProduct(product.id, product.name, product.mass, product.country)
            call.respond(product)
        }

        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            dao.deleteProduct(id.toInt())
            call.respond(HttpStatusCode.OK)
        }
    }
}