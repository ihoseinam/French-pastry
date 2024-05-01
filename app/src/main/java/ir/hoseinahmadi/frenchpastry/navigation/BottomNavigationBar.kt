package ir.hoseinahmadi.frenchpastry.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person2
import androidx.compose.material.icons.outlined.ShoppingBasket
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person2
import androidx.compose.material.icons.rounded.ShoppingBasket
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.hoseinahmadi.frenchpastry.util.Constants.CHECKED_LOGIN
import ir.hoseinahmadi.frenchpastry.viewModel.HomeViewModel

@Composable
fun BottomNavigationBar(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    /*
        val item = listOf<MyBottomNavItem>(
            MyBottomNavItem(
                route = Screen.HomeScreen.route,
                icon = painterResource(id = R.drawable.home)
            ),

            MyBottomNavItem(
                route = Screen.HomeScreen.route,
                icon = painterResource(id = R.drawable.cake)
            ),
            MyBottomNavItem(
                route = Screen.HomeScreen.route,
                icon = painterResource(id = R.drawable.ic_shopingcard)
            ),
            MyBottomNavItem(
                route = Screen.HomeScreen.route,
                icon = painterResource(id = R.drawable.coin)
            ),

            MyBottomNavItem(
                route = "A",
                icon = painterResource(id = R.drawable.user)
            ),
        )
    */

    val item = listOf<MyBottomNavItem>(
        MyBottomNavItem(
            route = Screen.HomeScreen.route,
            selectedIcon = Icons.Rounded.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),

        MyBottomNavItem(
            route = Screen.CategoryScreen.route,
            selectedIcon = Icons.Rounded.Category,
            unselectedIcon = Icons.Outlined.Category,
        ),

        MyBottomNavItem(
            route = Screen.BasketScreen.route,
            selectedIcon = Icons.Rounded.ShoppingBasket,
            unselectedIcon = Icons.Outlined.ShoppingBasket,
        ),

        MyBottomNavItem(
            route = Screen.ProfileScreen.route,
            selectedIcon = Icons.Rounded.Person2,
            unselectedIcon = Icons.Outlined.Person2,
        ),
    )

    val backStackEntry = navHostController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in item.map { it.route }


    AnimatedVisibility(
        visible = showBottomBar && CHECKED_LOGIN,
        enter = fadeIn(),
        exit =  fadeOut(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            HorizontalDivider(
                thickness = 1.3.dp,
                color = Color.LightGray.copy(0.6f)
            )
            NavigationBar(
                containerColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
            ) {
                item.forEachIndexed { index, item ->
                    val selected = item.route == backStackEntry.value?.destination?.route
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color.DarkGray,
                            indicatorColor = Color.Black,
                        ),
                        selected = selected,
                        onClick = { navHostController.navigate(item.route) },
                        icon = {
                            if (selected) item.selectedIcon else item.unselectedIcon
                            Icon(
                                imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
                                contentDescription = "",
                            )
                        })
                }


            }
        }
    }
}
