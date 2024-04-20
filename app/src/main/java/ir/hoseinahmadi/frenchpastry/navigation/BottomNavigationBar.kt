package ir.hoseinahmadi.frenchpastry.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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

    val navBakeStack = navHostController.currentBackStackEntry
    val show = navBakeStack?.destination?.route in item.map { it.route }
    Column {
        HorizontalDivider(
            thickness = 1.3.dp,
            color = Color.LightGray.copy(0.6f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            item.forEachIndexed { index, item ->
                val selected =navBakeStack?.destination?.route ==item.route
                NavigationBarItem(
                    selected = selected,
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
