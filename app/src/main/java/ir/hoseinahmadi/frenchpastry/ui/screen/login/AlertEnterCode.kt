package ir.hoseinahmadi.frenchpastry.ui.screen.login

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.R
import ir.hoseinahmadi.frenchpastry.ui.screen.home.HomeScreenState
import ir.hoseinahmadi.frenchpastry.ui.theme.body2
import ir.hoseinahmadi.frenchpastry.ui.theme.font_bold
import ir.hoseinahmadi.frenchpastry.ui.theme.h1
import ir.hoseinahmadi.frenchpastry.ui.theme.h5
import ir.hoseinahmadi.frenchpastry.ui.theme.h6
import ir.hoseinahmadi.frenchpastry.util.PastryHelper
import ir.hoseinahmadi.frenchpastry.viewModel.DatStoreViewModel
import ir.hoseinahmadi.frenchpastry.viewModel.HomeViewModel
import ir.hoseinahmadi.mydigikala.ui.component.Loading3Dots
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun AlertEnterCode(
    time:Int,
    homeViewModel: HomeViewModel = hiltViewModel(),
    datStoreViewModel: DatStoreViewModel = hiltViewModel()
) {

    if (steepLogin.intValue == 2) {


        val loading by homeViewModel.loading.collectAsState()
        val errorVerifyCode by homeViewModel.errorVerifyCode.collectAsState()


        LaunchedEffect(true) {
            launch {
                homeViewModel.verifyCodeResponse.collectLatest {
                    if (it.http_code == 200) {
                        Log.e("pasi", "code is success ${it.message}")
                        withContext(Dispatchers.Main) {
                            homeViewModel.homeScreenState = HomeScreenState.HomeScreen
                            datStoreViewModel.saveUserLogin(true)
                            datStoreViewModel.saveUserPhone(homeViewModel.userPhone)
                        }
                    }
                }
            }
        }


        AlertDialog(
            containerColor = Color.White,
            onDismissRequest = { /*TODO*/ },
            icon = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    IconButton(
                        onClick = { steepLogin.intValue = 1 }) {
                        Icon(
                            painter = painterResource(id = R.drawable.close),
                            contentDescription = "",
                            Modifier.size(25.dp),
                            tint = Color.Black
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp)
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "کد تائید",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.h1,
                            fontWeight = FontWeight.Black,
                            color = Color.Black,
                            fontFamily = font_bold
                        )

                        Text(
                            text = "کد ارسالی به شماره ${PastryHelper.pastryByLocate(homeViewModel.userPhone)} را وارد کنید",
                            style = MaterialTheme.typography.h6,
                            maxLines = 2,
                            color = Color.DarkGray
                        )
                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )
                        MyEditText(
                            value = homeViewModel.userCode,
                            placeholder = "کد تائید را وارد کنید",
                            onValueChange = {
                                if (homeViewModel.userCode.length <= 5) {
                                    homeViewModel.userCode = it
                                }
                            },
                            onError = errorVerifyCode,
                            timer = PastryHelper.pastryByLocate(formatTime(time))
                        )
                        if (errorVerifyCode) {
                            Text(
                                modifier = Modifier.padding(6.dp),
                                text = "کد وارد شده اشتباه است",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.h6,
                                color = Color.Red,
                                fontWeight = FontWeight.Bold
                            )

                        }

                        Column(
                            modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                shape = RoundedCornerShape(9.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.White
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(43.dp)
                                    .padding(vertical = 3.dp),
                                onClick = {
                                    homeViewModel.verifyCode()
                                }) {
                                AnimatedVisibility(visible = (steepLogin.intValue == 2 && loading)) {
                                    Loading3Dots(isDark = false)
                                }
                                AnimatedVisibility(visible = !loading) {
                                    Text(
                                        text = " تائید و ادامه",
                                        style = MaterialTheme.typography.body2,
                                        color = Color.White,
                                    )
                                }
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    modifier = Modifier.clickable { steepLogin.intValue = 1 },
                                    text = "ویرایش شماره",
                                    color = Color.Black,
                                    style = MaterialTheme.typography.body2
                                )



                            }

                        }
                    }


                }

            },
            confirmButton = {


            },
        )
    }


}