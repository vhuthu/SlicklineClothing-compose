package com.vhuthuk.slicklineclothing.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.vhuthuk.slicklineclothing.domain.mappers.model.ClothingItem
import com.vhuthuk.slicklineclothing.domain.mappers.model.Rating

@Composable
fun ShopList(modifier: Modifier = Modifier) {

}

@Composable
fun ShopItems(clothingItem: ClothingItem,modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth()) {
        GlideImage(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(80.dp)
                .padding(15.dp),
            imageModel = {clothingItem.imageUrl},
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShopItemsPreviews(modifier: Modifier = Modifier) {
    val items = ClothingItem(
        id = 1,
        title = "Back Pack",
        description = "A nice back pack that is stylish and very cute !!",
        price = 108.55,
        imageUrl = "",
        category = "clothes",
        rating = Rating(5.5,1)
    )
    ShopItems(clothingItem = items)
}