package com.example.dbconnection

import com.example.dbconnection.DatabaseFactory.dbQuery
import com.example.models.*
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToProduct(row: ResultRow) = Product(
        id = row[Products.id],
        name = row[Products.name],
        mass = row[Products.mass],
        country = row[Products.country],
    )

    private fun resultRowToCountry(row: ResultRow) = Country(
        name = row[Countries.name],
        distance = row[Countries.distance],
        president = row[Countries.president],
        surface = row[Countries.surface],
    )
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

    override suspend fun product(id: Int): Product? = dbQuery {
        Products
            .select {Products.id eq id}
            .map(::resultRowToProduct)
            .singleOrNull()
    }

    override suspend fun editProduct(id: Int, name: String, mass: Double, country: String): Boolean = dbQuery {
        Products.update({Products.id eq id}) {
            it[Products.name] = name
            it[Products.mass] = mass
            it[Products.country] = country
        } > 0
    }

    override suspend fun deleteProduct(id: Int): Boolean = dbQuery {
        Products.deleteWhere { Products.id eq id} > 0
    }

    override suspend fun allCountries(): List<Country> = dbQuery {
        Countries.selectAll().map(::resultRowToCountry)
    }

    override suspend fun addNewCountry(name: String, distance: Double, president: String, surface: Double): Country? = dbQuery {
        val toBeInserted = Countries.insert {
            it[Countries.name] = name
            it[Countries.distance] = distance
            it[Countries.president] = president
            it[Countries.surface] = surface
        }

        toBeInserted.resultedValues?.singleOrNull()?.let(::resultRowToCountry)
    }

    override suspend fun country(name: String): Country? = dbQuery{
        Countries
            .select {Countries.name eq name}
            .map(::resultRowToCountry)
            .singleOrNull()
    }

    override suspend fun editCountry(name: String, distance: Double, president: String, surface: Double): Boolean = dbQuery {
        Countries.update({Countries.name eq name}) {
            it[Countries.distance] = distance
            it[Countries.president] = president
            it[Countries.surface] = surface
        } > 0
    }

    override suspend fun deleteCountry(name: String): Boolean = dbQuery {
        Countries.deleteWhere { Countries.name eq name} > 0
    }
}

val dao: DAOFacade = DAOFacadeImpl().apply {
    runBlocking {

        if(allCountries().isEmpty()) {
            addNewCountry("Poland", 0.0, "Mr. Andrzej Duda", 312710.0)
        }

        if(allProducts().isEmpty()) {
            addNewProduct(1, "grass", 0.123, "Poland")
        }
    }
}