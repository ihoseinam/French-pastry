package ir.hoseinahmadi.frenchpastry.ui.screen.product_detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.data.model.product_detail.ProductResponse
import ir.hoseinahmadi.frenchpastry.viewModel.ProductDetailViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ProductDetailScreen(
    navHostController: NavHostController,
    productId: Int,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {
    productDetailViewModel.getProductById(productId)
    LaunchedEffect(true) {
        productDetailViewModel.productItem.collectLatest {
            Log.e("pasi",it.message)
        }
    }

}