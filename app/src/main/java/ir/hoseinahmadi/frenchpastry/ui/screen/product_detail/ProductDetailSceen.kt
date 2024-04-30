package ir.hoseinahmadi.frenchpastry.ui.screen.product_detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.hoseinahmadi.frenchpastry.R
import ir.hoseinahmadi.frenchpastry.data.model.product_detail.Pastry
import ir.hoseinahmadi.frenchpastry.data.model.product_detail.ProductResponse
import ir.hoseinahmadi.frenchpastry.ui.screen.home.TopSliderSection
import ir.hoseinahmadi.frenchpastry.ui.theme.font_bold
import ir.hoseinahmadi.frenchpastry.ui.theme.h2
import ir.hoseinahmadi.frenchpastry.ui.theme.h3
import ir.hoseinahmadi.frenchpastry.viewModel.ProductDetailViewModel
import ir.hoseinahmadi.mydigikala.ui.component.OurLoading
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun ProductDetailScreen(
    navHostController: NavHostController,
    productId: Int,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {
    ProductScreen(
        navHostController,
        productId,
        productDetailViewModel,
    )
}


@Composable
private fun ProductScreen(
    navHostController: NavHostController,
    productId: Int,
    productDetailViewModel: ProductDetailViewModel
) {

    var pastryItem by remember {
        mutableStateOf(ProductResponse())
    }

    var slider by remember {
        mutableStateOf<List<String>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(productId) {
        launch { productDetailViewModel.getProductById(productId) }
        launch {
            productDetailViewModel.productItem.collectLatest {
                if (it.http_code == 200 && it.pastry != null) {
                    pastryItem = it
                    slider = it.pastry.gallery
                    loading = false
                } else {
                    loading = true
                }
            }
        }
    }

    val scope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    val config = LocalConfiguration.current

    if (loading) {
        OurLoading(height = config.screenHeightDp.dp - 60.dp, isDark = true)
    } else {
        SwipeRefresh(state = swipeRefreshState,
            onRefresh = {
                scope.launch { refreshedItem(productDetailViewModel, productId) }
            }) {
            Scaffold(
                topBar = {
                    TopBarDetail(navHostController = navHostController)
                }
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xffF0F3FF))
                        .padding(it)
                ) {
                    item { Spacer(modifier = Modifier.height(20.dp)) }
                    item { Header(pastryItem.pastry!!.title) }
                    item { TopInfoDetail() }
                    item { TopSliderSection(slider) }
                }
            }
        }

    }

}


suspend fun refreshedItem(productDetailViewModel: ProductDetailViewModel, productId: Int) {
    productDetailViewModel.getProductById(productId)

}

@Composable
private fun Header(title: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_header),
            contentDescription = "",
            Modifier.size(38.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = title,
            color = Color(0xff101219),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h2,
            fontFamily = font_bold,
            fontSize = 22.sp,
        )
    }

}