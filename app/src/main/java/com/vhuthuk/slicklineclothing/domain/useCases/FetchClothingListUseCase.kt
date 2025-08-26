package com.vhuthuk.slicklineclothing.domain.useCases

import com.vhuthuk.slicklineclothing.domain.mappers.model.ClothingItem
import com.vhuthuk.slicklineclothing.domain.repository.FetchClothingListRepository
import com.vhuthuk.slicklineclothing.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class FetchClothingListUseCase(
    private val fetchClothingListRepository: FetchClothingListRepository
) {
//    suspend operator fun invoke(): Flow<Resource<List<ClothingItem>>> =
//        fetchClothingListRepository.fetchClothingItems()
//            .map { items -> Resource.Success(items) as Resource<List<ClothingItem>> }
//            .catch { e -> emit(Resource.Error(e.localizedMessage ?: "something wrong here!")) }
//            .onStart { emit(Resource.Loading) }

     operator fun invoke(): Flow<Resource<List<ClothingItem>>> =
        fetchClothingListRepository.fetchClothingItems()
            .map<List<ClothingItem>, Resource<List<ClothingItem>>> { items ->
                Resource.Success(items)
            }
            .onStart { emit(Resource.Loading) }
            .catch { e -> emit(Resource.Error(e.localizedMessage ?: "something wrong here!")) }
}