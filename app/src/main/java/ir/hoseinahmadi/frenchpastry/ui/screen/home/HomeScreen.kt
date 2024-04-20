package ir.hoseinahmadi.frenchpastry.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.hoseinahmadi.frenchpastry.data.model.home.Pastry
import ir.hoseinahmadi.frenchpastry.data.model.home.PastryItem
import ir.hoseinahmadi.frenchpastry.viewModel.HomeViewModel
import ir.hoseinahmadi.mydigikala.ui.component.OurLoading
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    Home(navHostController, homeViewModel)

}

@Composable
fun Home(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel
) {

    var loading by remember {
        mutableStateOf(true)
    }

    var newItemList by remember {
        mutableStateOf<Pastry>(Pastry())
    }

    var amazingItemList by remember {
        mutableStateOf<Pastry>(Pastry())
    }
    var topItemList by remember {
        mutableStateOf<Pastry>(Pastry())
    }

    LaunchedEffect(true) {
        refreshedMain(homeViewModel)
    }

    val mainResponse by homeViewModel.mainResponse.collectAsState()

    if (mainResponse.success == 1) {
        loading = false
        newItemList = mainResponse.pastries[0]
        amazingItemList = mainResponse.pastries[1]
        topItemList = mainResponse.pastries[2]

    }
    val scope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    val config = LocalConfiguration.current

    SwipeRefresh(state = swipeRefreshState,
        onRefresh = { scope.launch { refreshedMain(homeViewModel = homeViewModel) } })
    {
        if (loading) {
            OurLoading(height = config.screenHeightDp.dp - 60.dp, isDark = true)
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    TopProductHeader(
                        title = mainResponse.pastries[0].title,
                        onClick = {}
                    )
                }
                item { NewProductSection(navHostController = navHostController, item = newItemList.pastries) }
            }
        }

    }


}


private suspend fun refreshedMain(homeViewModel: HomeViewModel) {
    homeViewModel.getMain()
}
