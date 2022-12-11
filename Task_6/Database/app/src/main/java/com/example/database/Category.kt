package com.example.database

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Category() : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()
    var name: String = ""

    constructor(name: String = "") : this() {
        this.name = name
    }
}