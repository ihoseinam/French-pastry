package ir.hoseinahmadi.frenchpastry.ui.screen.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.data.model.home.PastryItem

@Composable
fun NewProductSection(
    navHostController: NavHostController,
    item:List<PastryItem>
){
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(item){
            HomeItemCard(navHostController, it) }
    }
}
