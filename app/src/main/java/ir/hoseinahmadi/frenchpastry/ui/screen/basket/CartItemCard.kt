package ir.hoseinahmadi.frenchpastry.ui.screen.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ir.hoseinahmadi.frenchpastry.R
import ir.hoseinahmadi.frenchpastry.data.db.entites.ShopEntities
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.ui.theme.body2
import ir.hoseinahmadi.frenchpastry.ui.theme.darkText
import ir.hoseinahmadi.frenchpastry.ui.theme.h6
import ir.hoseinahmadi.frenchpastry.util.PastryHelper
import ir.hoseinahmadi.frenchpastry.viewModel.ShopViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CartItemCard(
    item: ShopEntities,
    shopViewModel: ShopViewModel = hiltViewModel()
) {

    Card(
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth(),
        onClick = { /*TODO*/ },
    )
    {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp, start = 8.dp),
            text = item.title,
            style = MaterialTheme.typography.body1,
            color = Color.Black
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier
                    .size(30.dp),
                onClick = { shopViewModel.deleteShopOrder(item) }) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.deleteorder),
                    contentDescription = "",
                )
            }
            GlideImage(
                modifier = Modifier
                    .size(140.dp, 92.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(15.dp)),
                model = item.img,
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.padding(horizontal = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, top = 4.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (item.discount != 0) {
                        Text(
                            text = PastryHelper.pastryByLocateAndSeparator((item.price * item.count / 10).toString()),
                            style = MaterialTheme.typography.body1,
                            color = Color.LightGray.copy(0.9f),
                            textDecoration = TextDecoration.LineThrough
                        )
                        Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = PastryHelper.pastryByLocateAndSeparator(
                                PastryHelper.applyDiscount(
                                    (item.price * item.count) / 10.toLong(),
                                    item.discount
                                ).toString()
                            ),
                            style = MaterialTheme.typography.body1,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Icon(painter = painterResource(id = R.drawable.toman),
                            contentDescription = "",
                            Modifier.size(20.dp),
                            tint = Color.Black
                            )
                    }



                }
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                var showMenu3 by remember {
                    mutableStateOf(false)
                }

                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xffF0F3FF))
                        .padding(horizontal = 14.dp, vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = PastryHelper.pastryByLocate(" ${item.count} کیلو گرم "),
                        style = MaterialTheme.typography.body2,
                        color = Color.Black,
                    )


                    Column(
                        horizontalAlignment = Alignment.End,
                    ) {
                        Icon(
                            Icons.Rounded.KeyboardArrowDown,
                            contentDescription = "",
                            Modifier.clickable { showMenu3 = true }
                        )

                        DropdownMenu(
                            modifier = Modifier.background(Color(0xffF0F3FF)),
                            expanded = showMenu3,
                            onDismissRequest = { showMenu3 = false }
                        ) {
                            var items = listOf(
                                1, 2, 3, 4, 5
                            )
                            if (item.count >= 10) {
                                items = listOf(10, 20, 30, 40, 50)
                            }
                            items.forEachIndexed { index, i ->
                                DropdownMenuItem(
                                    colors = MenuDefaults.itemColors(textColor = Color.Black),
                                    text = {

                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = PastryHelper.pastryByLocate(i.toString()),
                                                style = MaterialTheme.typography.body2,
                                                color = MaterialTheme.colorScheme.darkText,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = "کیلو گرم",
                                                style = MaterialTheme.typography.h6,
                                                color = MaterialTheme.colorScheme.darkText
                                            )
                                        }

                                    },
                                    onClick = {
                                        showMenu3 = false
                                        shopViewModel.changeCartItem(item.id, i)
                                    })
                            }


                        }
                    }
                }
            }

        }

        HorizontalDivider(
            thickness = 1.dp,
            color = Color.LightGray.copy(0.5f),
            modifier = Modifier.padding(vertical = 9.dp)
        )
    }
}