package ir.hoseinahmadi.frenchpastry.ui.screen.fave

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.ui.screen.product_detail.Header
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.viewModel.FaveViewModel

@Composable
fun FaveScreen(
    navHostController: NavHostController,
    faveViewModel: FaveViewModel = hiltViewModel()
) {

    val allData by faveViewModel.allData.collectAsState(initial = emptyList())

    Scaffold(
        containerColor = Color(0xffF0F3FF),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 5.dp,
                        vertical = 8.dp
                    ),
                horizontalArrangement = Arrangement.Start,
            ) {
                IconButton(onClick = { navHostController.popBackStack() }) {
                    Icon(
                        Icons.Rounded.Close,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }


        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            item { Header(title = "لیست علاقه مندی") }
            if (allData.isEmpty()){
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 20.dp),
                        text = "لیست علاقه مندی ها خالی می باشد",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }else{
                items(allData){item ->
                    FaveItemCard(item = item, viewModel = faveViewModel)
                }
            }

        }
    }
}
