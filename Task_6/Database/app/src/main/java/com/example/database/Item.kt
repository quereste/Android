package com.example.database

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Item() : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()
    var name: String = ""
    var description: String = ""
    var category: Category? = null
    var numberOfProducts: Int = 0

    constructor(name: String = "", description: String = "", category: Category) : this() {
        this.name = name
        this.description = description
        this.category = category
    }
}