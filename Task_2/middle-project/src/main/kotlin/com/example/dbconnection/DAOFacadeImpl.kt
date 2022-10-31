package com.example.dbconnection

import com.example.dbconnection.DatabaseFactory.dbQuery
import com.example.models.Customer
import com.example.models.Customers
import com.example.models.Product
import com.example.models.Products
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToCustomer(row: ResultRow) = Customer(
        id = row[Customers.id],
        firstName = row[Customers.firstName],
        lastName = row[Customers.lastName],
        email = row[Customers.email],
    )

    private fun resultRowToProduct(row: ResultRow) = Product(
        id = row[Products.id],
        name = row[Products.name],
        mass = row[Products.mass],
        country = row[Products.country],
    )

    override suspend fun allCustomers(): List<Customer> = dbQuery {
        Customers.selectAll().map(::resultRowToCustomer)
    }

    override suspend fun customer(id: Int): Customer? = dbQuery {
        Customers
            .select {Customers.id eq id}
            .map(::resultRowToCustomer)
            .singleOrNull()
    }

    override suspend fun addNewCustomer(id: Int, firstName: String, lastName: String, email: String): Customer? = dbQuery {
        val toBeInserted = Customers.insert {
         it[Customers.id] = id
         it[Customers.firstName] = firstName
         it[Customers.lastName] = lastName
         it[Customers.email] = email
        }

        toBeInserted.resultedValues?.singleOrNull()?.let(::resultRowToCustomer)
    }

    override suspend fun editCustomer(id: Int, firstName: String, lastName: String, email: String): Boolean = dbQuery {
        Customers.update({Customers.id eq id}) {
            it[Customers.firstName] = firstName
            it[Customers.lastName] = lastName
            it[Customers.email] = email
        } > 0
    }

    override suspend fun deleteCustomer(id: Int): Boolean = dbQuery {
        Customers.deleteWhere { Customers.id eq id} > 0
    }

    override suspend fun allProducts(): List<Product> = dbQuery {
        Products.selectAll().map(::resultRowToProduct)
    }

    override suspend fun addNewProduct(id: Int, name: String, mass: Double, country: String): Product? = dbQuery {
        val toBeInserted = Products.insert {
            it[Products.id] = id
            it[Products.name] = name
            it[Products.mass] = mass
            it[Products.country] = country
        }

        toBeInserted.resultedValues?.singleOrNull()?.let(::resultRowToProduct)
    }
}

val dao: DAOFacade = DAOFacadeImpl().apply {
    runBlocking {
        if(allCustomers().isEmpty()) {
            addNewCustomer(1, "azer", "bejdżan", "mail.me@xd.xd")
        }
        if(allProducts().isEmpty()) {
            addNewProduct(1, "grass", 0.123, "Poland")
        }
    }
}