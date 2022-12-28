package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer(val username: String, val password: String, val name: String, val surname: String)

val customerMemory = mutableListOf<Customer>(
    Customer("admin", "admin", "Tomasz", "Szczepanik"),
    Customer("elszczupakabra", "notadmin", "Jan", "Kowalski")
)