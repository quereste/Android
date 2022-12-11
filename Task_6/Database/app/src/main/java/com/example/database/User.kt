package com.example.database

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class User() : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()
    var name: String = ""
    var surname: String = ""
    var age: Int = 0
    var cart: ShoppingCart? = null

    constructor(name: String = "", surname: String = "", age: Int = 0, cart: ShoppingCart? = null) : this() {
        this.name = name
        this.surname = surname
        this.age = age
        this.cart = cart
    }
}