package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Customer(val id: Int, val firstName: String, val lastName: String, val email: String)

object Customers : Table() {
    val id = integer("id")
    val firstName = varchar("firstname", 128)
    val lastName = varchar("lastname", 128)
    val email = varchar("email", 128)

    override val primaryKey = PrimaryKey(id)
}

