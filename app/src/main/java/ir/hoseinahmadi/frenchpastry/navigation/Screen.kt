package ir.hoseinahmadi.frenchpastry.navigation

sealed class Screen(val route:String) {


    data object SplashScreen:Screen("Splash_Screen")

    data object HomeScreen:Screen("Home_Screen")
    data object LoginScreen:Screen("Login_Screen")
}