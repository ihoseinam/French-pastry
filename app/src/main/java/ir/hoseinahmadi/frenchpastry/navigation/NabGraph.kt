package ir.hoseinahmadi.frenchpastry.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.hoseinahmadi.frenchpastry.ui.screen.BasketScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.CategoryScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.home.HomeScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.login.LoginScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.product_detail.ProductDetailScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.product_detail.comment.CommentAndRepliesScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.profile.ProfileInfoScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.profile.ProfileScreen
import ir.hoseinahmadi.frenchpastry.ui.screen.splash.SplashScreen

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navHostController = navHostController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navHostController = navHostController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navHostController = navHostController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navHostController)
        }
        composable(Screen.BasketScreen.route) {
            BasketScreen()
        }
        composable(Screen.CategoryScreen.route) {
            CategoryScreen()
        }
        composable(Screen.ProductDetailScreen.route + "?id={id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 34
                }
            )
        ) {
            it.arguments?.getInt("id")?.let { id ->
                ProductDetailScreen(
                    navHostController = navHostController,
                    productId = id
                )
            }


        }
        composable(Screen.ProfileInfoScreen.route){
            ProfileInfoScreen(navHostController)
        }
        composable(Screen.CommentAndReplies.route + "?data={data}",
            arguments = listOf(
                navArgument("data"){
                    type = NavType.StringType
                    defaultValue =""
                    nullable =true
                }
            )
            ){
            CommentAndRepliesScreen(
                data = it.arguments?.getString("data").toString()
            )
        }

    }
}