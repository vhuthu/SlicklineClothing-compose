package com.vhuthuk.slicklineclothing.ui.screens.homeScreen

import android.app.Application
import android.util.Log
import androidx.compose.material3.Snackbar
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.vhuthuk.slicklineclothing.domain.mappers.model.ClothingItem
import com.vhuthuk.slicklineclothing.domain.useCases.FetchClothingListUseCase
import com.vhuthuk.slicklineclothing.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    application: Application,
    private val fetchClothingListUseCase: FetchClothingListUseCase
) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow<Resource<List<ClothingItem>>>(Resource.Loading)
    val uiState: StateFlow<Resource<List<ClothingItem>>> = _uiState

    init {
        getClothingList()
    }

    private fun getClothingList() {
        viewModelScope.launch {
            fetchClothingListUseCase()
                .collectLatest { result ->
                    _uiState.value = result
                    Log.d("SuccessV", result.toString())

                }
        }
    }
}