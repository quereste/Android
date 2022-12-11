package com.example.database

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class ShoppingCart() : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()
    var items: RealmList<Item> = realmListOf<Item>()
}