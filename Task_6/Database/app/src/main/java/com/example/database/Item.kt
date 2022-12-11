package com.example.database

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Item() : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()
    var name: String = ""
    var description: String = ""
    var category: Int = 0

    constructor(name: String = "", description: String = "", category: Int = 0) : this() {
        this.name = name
        this.description = description
        this.category = category
    }
}