package ir.hoseinahmadi.frenchpastry.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.data.model.home.Pastry
import ir.hoseinahmadi.frenchpastry.data.model.home.PastryItem
import ir.hoseinahmadi.frenchpastry.viewModel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    var amazingItem by remember {
        mutableStateOf<Pastry>(Pastry())
    }
    val mainResponse by homeViewModel.mainResponse.collectAsState()

    // LaunchedEffect برای فراخوانی تابع getMain() هنگام ساخت کامپوزابل
    LaunchedEffect(true) {
        homeViewModel.getMain()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (mainResponse.pastries.isNotEmpty()) {
            val firstPastryItem = mainResponse.pastries[1].title
            amazingItem =mainResponse.pastries[1]
            Text(
                text =amazingItem.toString()
            )
            // برای نمایش تصویر و سایر اطلاعات می‌توانید از سایر کامپوزابل‌ها مثل Image استفاده کنید.
        } else {
            Text(text = "No pastries available")
        }
    }
    // نمایش اطلاعات اولین pastry، در صورتی که لیست خالی نباشد

}
