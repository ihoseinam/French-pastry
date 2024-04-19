package ir.hoseinahmadi.frenchpastry.ui.screen.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController) {
    LaunchedEffect(true) {
        delay(1000)
        navHostController.navigate(Screen.HomeScreen.route)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SplashScreen",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
    }
}