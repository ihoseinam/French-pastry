package ir.hoseinahmadi.frenchpastry.ui.screen.profile

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gmail.hamedvakhide.compose_jalali_datepicker.JalaliDatePickerDialog
import ir.hoseinahmadi.frenchpastry.R
import ir.hoseinahmadi.frenchpastry.navigation.Screen
import ir.hoseinahmadi.frenchpastry.ui.screen.product_detail.Header
import ir.hoseinahmadi.frenchpastry.ui.theme.h1
import ir.hoseinahmadi.frenchpastry.ui.theme.h2
import ir.hoseinahmadi.frenchpastry.util.Constants
import ir.hoseinahmadi.frenchpastry.util.PastryHelper

@OptIn(ExperimentalComposeUiApi::class, ExperimentalLayoutApi::class)
@Composable
fun ProfileScreen(
    navHostController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff141217))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterEnd){
                Image(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(110.dp),
                    painter = painterResource(id = R.drawable.img_profile_lines),
                    contentDescription ="",
                    contentScale = ContentScale.FillBounds
                    )
            }

            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = Constants.USER_NAME,
                        style = MaterialTheme.typography.h1,
                        color = Color.White,
                        fontWeight = FontWeight.Black
                    )
                    Text(text =PastryHelper.pastryByLocate(Constants.USER_PHONE),
                        style = MaterialTheme.typography.h2,
                        color = Color.White,
                    )

                }
            }
        }
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp))
                .fillMaxSize()
                .background(Color.White),
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Header("سفارش های من")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                BasketItem(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.img_sell_state1))
                BasketItem(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.img_sell_state2))
                BasketItem(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.img_sell_state3))
                BasketItem(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.img_sell_state4))
            }
            Spacer(modifier = Modifier.height(12.dp))
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp),
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ProfileItem(
                    onClick = { navHostController.navigate(Screen.ProfileInfoScreen.route) },
                    painter = painterResource(id = R.drawable.img_my_info)
                )
                ProfileItem(
                    onClick = {},
                    painter = painterResource(id = R.drawable.img_my_interests)
                )
                ProfileItem(
                    onClick = {},
                    painter = painterResource(id = R.drawable.img_my_address)
                )
                ProfileItem(
                    onClick = {},
                    painter = painterResource(id = R.drawable.img_my_discounts)
                )
                ProfileItem(
                    onClick = {},
                    painter = painterResource(id = R.drawable.img_cake_custom)
                )
                ProfileItem(
                    onClick = {},
                    painter = painterResource(id = R.drawable.img_my_notification)
                )
            }


        }

    }


}

