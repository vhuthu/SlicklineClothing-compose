package com.vhuthuk.slicklineclothing.data.remote

import com.vhuthuk.slicklineclothing.data.remote.clothingListModel.ClothingList
import retrofit2.http.GET


interface ClothingApi {

    @GET("products")
    suspend fun fetchClothingItems(): List<ClothingList>
}