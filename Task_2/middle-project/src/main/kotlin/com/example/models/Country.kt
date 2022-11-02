package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Country(val name: String, val distance: Double, val president: String, val surface: Double)

object Countries : Table() {
    val name = varchar("name", 128)
    val distance = double("distance")
    val president = varchar("president", 128)
    val surface = double("surface")

    override val primaryKey = PrimaryKey(name)
}

