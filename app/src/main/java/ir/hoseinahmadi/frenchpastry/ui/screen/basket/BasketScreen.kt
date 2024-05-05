package ir.hoseinahmadi.frenchpastry.ui.screen.basket

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import ir.hoseinahmadi.frenchpastry.viewModel.ShopViewModel

@Composable
fun BasketScreen(
    shopViewModel: ShopViewModel = hiltViewModel()
) {

    val allItem by shopViewModel.allItemShop.collectAsState(initial = emptyList())

    LazyColumn {
        items(allItem){
            CartItemCard(item = it)
        }
    }
}