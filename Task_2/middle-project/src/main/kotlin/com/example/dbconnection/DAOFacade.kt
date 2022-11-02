package com.example.dbconnection

import com.example.models.Country
import com.example.models.Customer
import com.example.models.Customers
import com.example.models.Product

interface DAOFacade {
    suspend fun allProducts(): List<Product>
    suspend fun addNewProduct(id: Int, name: String, mass: Double, country: String): Product?

    suspend fun product(id: Int): Product?

    suspend fun editProduct(id: Int, name: String, mass: Double, country: String): Boolean
    suspend fun deleteProduct(id: Int): Boolean

    suspend fun allCountries(): List<Country>
    suspend fun addNewCountry(name: String, distance: Double, president: String, surface: Double): Country?

    suspend fun country(name: String): Country?
    suspend fun editCountry(name: String, distance: Double, president: String, surface: Double): Boolean
    suspend fun deleteCountry(name: String): Boolean
}