package ir.hoseinahmadi.frenchpastry.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.hoseinahmadi.frenchpastry.ui.screen.home.HomeScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.login.LoginScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.splash.SplashScreen

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route){
            SplashScreen(navHostController = navHostController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(navHostController = navHostController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navHostController = navHostController)
        }

    }
}