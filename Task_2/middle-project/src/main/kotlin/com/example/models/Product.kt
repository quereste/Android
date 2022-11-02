package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Product(val id: Int, val name: String, val mass: Double, val country: String)

object Products : Table() {
    val id = integer("id")
    val name = varchar("name", 128)
    val mass = double("mass")
    val country = reference("country", Countries.name)

    override val primaryKey = PrimaryKey(id)
}

