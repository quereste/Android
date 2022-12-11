package com.example.database

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class ShoppingCart() : RealmObject {
    @PrimaryKey
    var productId: Int = 0
    var numberOfProducts: Int = 0

    constructor(numberOfProducts: Int = 0) : this() {
        this.numberOfProducts = numberOfProducts
    }
}