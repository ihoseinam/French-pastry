package ir.hoseinahmadi.frenchpastry.ui.screen.login

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ir.hoseinahmadi.frenchpastry.ui.screen.home.HomeScreenState
import ir.hoseinahmadi.frenchpastry.ui.theme.font_bold
import ir.hoseinahmadi.frenchpastry.ui.theme.h1
import ir.hoseinahmadi.frenchpastry.ui.theme.h3
import ir.hoseinahmadi.frenchpastry.ui.theme.h5
import ir.hoseinahmadi.frenchpastry.ui.theme.h6
import ir.hoseinahmadi.frenchpastry.util.InputValidation
import ir.hoseinahmadi.frenchpastry.util.PastryHelper
import ir.hoseinahmadi.frenchpastry.viewModel.DatStoreViewModel
import ir.hoseinahmadi.frenchpastry.viewModel.HomeViewModel
import ir.hoseinahmadi.mydigikala.ui.component.Loading3Dots
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

val steepLogin = mutableIntStateOf(1)

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


    val steep by remember {
        steepLogin
    }
    val loding by homeViewModel.loading.collectAsState()

    var error by remember {
        mutableStateOf(false)
    }

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
                placeholder = "شماره موبایل خود را وارد کنید",
                onError = error
            )
            if (error) {
                Text(
                    modifier = Modifier.padding(6.dp),
                    text = "فرمت شماره تلفن وارد شده صحیح نمی باشد",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h6,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )

            }else{
                Spacer(modifier = Modifier.height(15.dp))
            }

            LaunchedEffect(true) {
                homeViewModel.sendCodeResponse.collectLatest {
                    when (it.http_code) {
                        200 -> {
                            Log.e("pasi", it.message)
                            steepLogin.intValue = 2
                        }

                        400 -> {
                            /*       withContext(Dispatchers.Main) {
                                            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                                        }
                                        loding = false*/
                        }

                        else -> {

                        }
                    }
                }
            }
            AlertEnterCode(navHostController)


            var timeLeft by remember { mutableIntStateOf(180) }
            var isTimerRunning by remember { mutableStateOf(false) }
            val lifecycleOwner = LocalLifecycleOwner.current

            DisposableEffect(lifecycleOwner) {
                val observer = LifecycleEventObserver { _, event ->
                    if (event == Lifecycle.Event.ON_RESUME) {
                        // Timer should only run when the screen is active
                        isTimerRunning = false // Stop the timer when the screen is not active
                    }
                }
                lifecycleOwner.lifecycle.addObserver(observer)
                onDispose {
                    lifecycleOwner.lifecycle.removeObserver(observer)
                }
            }

            LaunchedEffect(isTimerRunning) {
                if (isTimerRunning) {
                    while (timeLeft > 0 && isTimerRunning) {
                        delay(1000)
                        timeLeft--
                    }
                    isTimerRunning = false
                }
            }

            if (isTimerRunning) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = ") شما میتوانید در ${PastryHelper.pastryByLocate(timeLeft.toString())}دیگر دوباره کد را درخواست کنید ",
                    color = Color.Red,
                    style = MaterialTheme.typography.h6
                )
            }
            Button(
                enabled = !isTimerRunning,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .width(210.dp)
                    .height(45.dp)
                    .padding(vertical = 2.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    if (InputValidation.isValidPhoneNumber(homeViewModel.userPhone)){
                        error =false
                        if (!isTimerRunning) {
                            homeViewModel.login()
                            timeLeft = 120 // Reset the timer to 2 minutes
                            isTimerRunning = true // Start the timer
                        }
                    }else{
                        error =true
                    }


                }) {
                AnimatedVisibility(visible = loding) {
                    Loading3Dots(isDark = false)
                }
                AnimatedVisibility(visible = !loding) {
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

}

@Composable
fun TimerScreen() {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {

        }) {
            Text("Start Timer")
        }
    }
}
