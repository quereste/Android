package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Item(val name: String, val category: String)

val itemList = mutableListOf<Item>(Item("sax", "marvelous instrument to play on one's nerves"),
                                   Item("keyboard", "power of mixed keys"),
                                   Item("guitar", "sharp as ever"),
                                   Item("piano", "let's play on old-fashioned keyboard"))

