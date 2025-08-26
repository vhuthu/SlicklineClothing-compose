package com.vhuthuk.slicklineclothing.di

import com.vhuthuk.slicklineclothing.data.remote.ClothingApi
import com.vhuthuk.slicklineclothing.domain.repository.FetchClothingListRepository
import com.vhuthuk.slicklineclothing.domain.repository.FetchClothingListRepositoryImpl
import com.vhuthuk.slicklineclothing.domain.useCases.FetchClothingListUseCase
import com.vhuthuk.slicklineclothing.util.Constants.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SlickLineClothingModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideClothingService(retrofit: Retrofit): ClothingApi =
        retrofit.create(ClothingApi::class.java)


    @Provides
    @Singleton
    fun provideClothingRepository(
        impl: FetchClothingListRepositoryImpl
    ): FetchClothingListRepository = impl

    @Provides
    @Singleton
    fun provideFetchClothingListUseCase(
        repository: FetchClothingListRepository
    ): FetchClothingListUseCase {
        return FetchClothingListUseCase(repository)
    }
}