package com.example.dbconnection

import com.example.models.Customer
import com.example.models.Customers
import com.example.models.Product

interface DAOFacade {
    suspend fun allCustomers(): List<Customer>
    suspend fun customer(id: Int): Customer?
    suspend fun addNewCustomer(id: Int, firstName: String, lastName: String, email: String): Customer?
    suspend fun editCustomer(id: Int, firstName: String, lastName: String, email: String): Boolean
    suspend fun deleteCustomer(id: Int): Boolean
    suspend fun allProducts(): List<Product>
    suspend fun addNewProduct(id: Int, name: String, mass: Double, country: String): Product?

    suspend fun product(id: Int): Product?
}