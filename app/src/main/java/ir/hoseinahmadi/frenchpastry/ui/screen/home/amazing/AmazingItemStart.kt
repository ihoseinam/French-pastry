package ir.hoseinahmadi.frenchpastry.ui.screen.home.amazing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.hoseinahmadi.frenchpastry.R

@Composable
fun AmazingItemStart() {
    Box(
        modifier = Modifier
            .width(125.dp)
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_amazingstart),
            contentDescription = ""
        )
    }


}