package com.vhuthuk.slicklineclothing.domain.mappers.model

data class ClothingItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val category: String,
    val rating: Rating
)

data class Rating(
    val value: Double,
    val count: Int
)