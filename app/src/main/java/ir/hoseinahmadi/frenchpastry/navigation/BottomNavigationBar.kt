package ir.hoseinahmadi.frenchpastry.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.hoseinahmadi.frenchpastry.R

@Composable
fun BottomNavigationBar(
    navHostController: NavHostController,
) {

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
            route = Screen.HomeScreen.route,
            icon = painterResource(id = R.drawable.user)
        ),
    )

    val backStackEntry = navHostController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in item.map { it.route }
    if (showBottomBar){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            HorizontalDivider(
                thickness = 1.3.dp,
                color = Color.LightGray.copy(0.6f)
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item.forEachIndexed { index, item ->
                    val selected = item.route == backStackEntry.value?.destination?.route
                    NavigationBarItem(
                        selected = false,
                        onClick = { navHostController.navigate(item.route) },
                        icon = {
                            Icon(painter = item.icon, contentDescription = "",
                                modifier = Modifier.size(26.dp),
                                tint = Color.Black
                            )
                        })
                }


            }
        }
    }



}
