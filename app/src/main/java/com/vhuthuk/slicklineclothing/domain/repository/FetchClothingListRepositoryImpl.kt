package com.vhuthuk.slicklineclothing.domain.repository

import com.vhuthuk.slicklineclothing.data.remote.ClothingApi
import com.vhuthuk.slicklineclothing.domain.mappers.model.ClothingItem
import com.vhuthuk.slicklineclothing.domain.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchClothingListRepositoryImpl @Inject constructor(
    private val clothingApi: ClothingApi
) : FetchClothingListRepository {

    override fun fetchClothingItems(): Flow<List<ClothingItem>> = flow {
        val items = clothingApi.fetchClothingItems().map { it.toDomain() }
        emit(items)
    }
}