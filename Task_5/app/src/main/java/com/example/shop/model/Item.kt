package com.example.shop.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    @StringRes val nameId: Int,
    @StringRes val descriptionId: Int,
    @DrawableRes val imageId: Int,
)