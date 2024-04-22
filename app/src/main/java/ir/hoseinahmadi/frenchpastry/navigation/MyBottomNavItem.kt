package ir.hoseinahmadi.frenchpastry.navigation

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class MyBottomNavItem(
    val route:String,
    val selectedIcon :ImageVector,
    val unselectedIcon :ImageVector,
)
