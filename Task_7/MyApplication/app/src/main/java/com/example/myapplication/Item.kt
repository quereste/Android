package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("name")
    val name: String,
    @SerializedName("category")
    val category: String,
)