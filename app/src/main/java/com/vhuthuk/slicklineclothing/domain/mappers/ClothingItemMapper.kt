package com.vhuthuk.slicklineclothing.domain.mappers

import com.vhuthuk.slicklineclothing.data.remote.clothingListModel.ClothingList
import com.vhuthuk.slicklineclothing.domain.mappers.model.ClothingItem
import com.vhuthuk.slicklineclothing.domain.mappers.model.Rating

fun ClothingList.toDomain(): ClothingItem {
    return ClothingItem(
        id = id,
        title = title,
        description = description,
        price = price,
        imageUrl = image,
        category = category,
        rating = Rating(
            value = rating.rate,
            count = rating.count
        )
    )
}