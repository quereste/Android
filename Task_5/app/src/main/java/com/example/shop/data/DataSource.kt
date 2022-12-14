package com.example.shop.data

import com.example.shop.R
import com.example.shop.model.Item

class DataSource {
    fun loadItems(): List<Item> {
        return listOf<Item>(
            Item(R.string.rectangle, R.string.rectangleD, R.drawable.square, 0),
            Item(R.string.square, R.string.squareD, R.drawable.square, 0),
            Item(R.string.triangle, R.string.triangleD, R.drawable.square, 0),
            Item(R.string.ellipse, R.string.ellipseD, R.drawable.square, 0),
            Item(R.string.segment, R.string.segmentD, R.drawable.square, 0),
            Item(R.string.point, R.string.pointD, R.drawable.square, 0),
            Item(R.string.circle, R.string.circleD, R.drawable.square, 0)
        )
    }
}