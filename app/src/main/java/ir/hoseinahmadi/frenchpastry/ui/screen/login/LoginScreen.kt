package ir.hoseinahmadi.frenchpastry.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ir.hoseinahmadi.frenchpastry.ui.screen.home.HomeScreenState
import ir.hoseinahmadi.frenchpastry.ui.theme.font_bold
import ir.hoseinahmadi.frenchpastry.ui.theme.h1
import ir.hoseinahmadi.frenchpastry.ui.theme.h3
import ir.hoseinahmadi.frenchpastry.ui.theme.h5
import ir.hoseinahmadi.frenchpastry.ui.theme.h6
import ir.hoseinahmadi.frenchpastry.viewModel.DatStoreViewModel
import ir.hoseinahmadi.frenchpastry.viewModel.HomeViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LoginScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
    datStoreViewModel: DatStoreViewModel = hiltViewModel()
) {

    val imgUr = listOf(
        "https://raw.githubusercontent.com/ihoseinam/video-shop/main/pastry/head_login.png",
        "https://raw.githubusercontent.com/ihoseinam/video-shop/main/pastry/logo_login.png",
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.55f),
            contentAlignment = Alignment.TopCenter
        ) {
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                model = imgUr[0],
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                GlideImage(
                    modifier = Modifier
                        .padding(top = 55.dp)
                        .size(205.dp, 121.dp),
                    model = imgUr[1],
                    contentDescription = "",
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 13.dp),
                    text = "ورود به برنامه",
                    style = MaterialTheme.typography.h3,
                    fontSize = 20.sp,
                    lineHeight = 30.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp)
                .weight(0.45f),
        ) {
            Text(
                text = "شیرینی فرانسوی",
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.Black,
                color = Color.Black,
                fontSize = 30.sp,
                lineHeight = 45.sp,
                fontFamily = font_bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                maxLines = 2,
                text = "جهت ورود به برنامه شماره موبایل خود را در کادر زیر وارد کرده و کدارسالی به موبایل خود را در برنامه وارد کنید.",
                style = MaterialTheme.typography.h5,
                color = Color(0xff555353),
                fontSize = 14.sp,
                lineHeight = 23.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            MyEditText(
                value = homeViewModel.userPhone,
                onValueChange = { homeViewModel.userPhone = it },
                placeholder = "شماره موبایل خود را وارد کنید"
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(vertical = 2.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    homeViewModel.homeScreenState =HomeScreenState.HomeScreen
//                    datStoreViewModel.saveUserLogin(true)
                }) {
                Text(
                    text = "ارسال کد به شماره موبایل من",
                    style = MaterialTheme.typography.h6,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

        }


    }

}