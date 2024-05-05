package ir.hoseinahmadi.frenchpastry.ui.screen.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.hoseinahmadi.frenchpastry.viewModel.ShopViewModel

@Composable
fun BasketScreen(
    shopViewModel: ShopViewModel = hiltViewModel()
) {

    val allItem by shopViewModel.allItemShop.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffF4F6FF))
    ) {
        item { Spacer(modifier = Modifier.height(30.dp)) }
        items(allItem){
            CartItemCard(item = it)
        }
    }
}