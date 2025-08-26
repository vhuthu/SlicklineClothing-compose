package com.vhuthuk.slicklineclothing.domain.repository

import com.vhuthuk.slicklineclothing.domain.mappers.model.ClothingItem
import kotlinx.coroutines.flow.Flow

interface FetchClothingListRepository {
    fun fetchClothingItems(): Flow<List<ClothingItem>>
}