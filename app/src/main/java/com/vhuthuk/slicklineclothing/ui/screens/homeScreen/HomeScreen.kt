package com.vhuthuk.slicklineclothing.ui.screens.homeScreen

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vhuthuk.slicklineclothing.domain.mappers.model.ClothingItem
import com.vhuthuk.slicklineclothing.util.Resource

@Composable
fun GreetingScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
   // this is all for just testing purpose will still need to refine the view model and this screeen and make resuable componanents
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is Resource.Loading -> {
            CircularProgressIndicator()
        }

        is Resource.Success -> {
            // smart cast works here
            val data = (uiState as Resource.Success<List<ClothingItem>>).data
            Text("Fetched ${data.toString()} items!")
        }

        is Resource.Error -> {
            Text("Error: ${(uiState as Resource.Error).message}")
        }
    }
}
