package com.example.myapplication

import retrofit2.Response
import retrofit2.http.GET

interface ItemService {

    @GET("/items")
    suspend fun getItems() : Response<ItemList>
}