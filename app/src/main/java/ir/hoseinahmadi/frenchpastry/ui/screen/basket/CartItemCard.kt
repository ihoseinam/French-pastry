package ir.hoseinahmadi.frenchpastry.ui.screen.basket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ir.hoseinahmadi.frenchpastry.data.db.entites.ShopEntities
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.ui.theme.body2
import ir.hoseinahmadi.frenchpastry.util.PastryHelper

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CartItemCard(item: ShopEntities) {

    Card(
        modifier = Modifier
            .padding(horizontal = 11.dp, vertical = 6.dp)
            .fillMaxWidth()
            .padding(5.dp),
        onClick = { /*TODO*/ },
    )
    {
        Text(
            text = item.title,
            style = MaterialTheme.typography.body2,
            color = Color.Black
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 3.dp)
        ) {

            GlideImage(
                modifier = Modifier.size(100.dp, 65.dp),
                model = item.img,
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.padding(horizontal = 3.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text =PastryHelper.pastryByLocateAndSeparator(item.priceOr.toString()) ,
                        style = MaterialTheme.typography.body1,
                        color = Color.DarkGray.copy(0.8f)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(
                        text =PastryHelper.pastryByLocateAndSeparator(item.salePrice.toString()) ,
                        style = MaterialTheme.typography.body1,
                        color = Color.Black
                    )
                }
                Text(text = item.count.toString())
            }

        }
    }
}