package ir.hoseinahmadi.frenchpastry

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.ui.theme.body2
import ir.hoseinahmadi.frenchpastry.util.Constants
import ir.hoseinahmadi.frenchpastry.util.PastryHelper
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(navHostController: NavHostController, drawerState: DrawerState) {
    Column(
        modifier = Modifier
            .background(Color(0xffF0F3FF))
            .fillMaxWidth(0.85f)
            .fillMaxHeight()
    ) {
        val scope = rememberCoroutineScope()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .background(Color(0xffF0F3FF))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                ) {
                    Icon(
                        painterResource(id = R.drawable.close),
                        contentDescription = "",
                        Modifier.size(25.dp),
                        tint = Color.Black
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .height(60.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_navigation_header),
                    contentDescription = "",
                    Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = Constants.USER_NAME,
                            color = Color.White,
                            style = MaterialTheme.typography.body1
                        )
                        Text(
                            text = PastryHelper.pastryByLocate(Constants.USER_PHONE),
                            color = Color.White,
                            style = MaterialTheme.typography.body2
                        )


                    }

                }
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Box(
                    contentAlignment = Alignment.Center){
                    Image(painter = painterResource(id = R.drawable.img_navigation),
                        contentDescription ="",
                        modifier = Modifier.fillMaxWidth()
                            .height(240.dp),
                        contentScale = ContentScale.FillBounds
                        )
                }
                Icon(
                    painter = painterResource(id = R.drawable.mylogo),
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier.size(300.dp,90.dp)
                )
                
            }
        }

    }
}

@Composable
fun TopItem(
    icon: Painter,
    title: String
) {


}