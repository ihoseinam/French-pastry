package ir.hoseinahmadi.frenchpastry.ui.screen.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ir.hoseinahmadi.frenchpastry.R
import ir.hoseinahmadi.frenchpastry.data.model.home.PastryItem
import ir.hoseinahmadi.frenchpastry.navigation.Screen
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.ui.theme.darkText
import ir.hoseinahmadi.frenchpastry.ui.theme.h3
import ir.hoseinahmadi.frenchpastry.ui.theme.h5
import ir.hoseinahmadi.frenchpastry.ui.theme.h6
import ir.hoseinahmadi.frenchpastry.util.PastryHelper.pastryByLocateAndSeparator

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeItemCard(
    navHostController: NavHostController,
    item: PastryItem
) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = {
                  navHostController.navigate(Screen.ProductDetailScreen.route+"?id=${item.ID}")
        },
        modifier = Modifier
            .padding(5.dp)
            .width(250.dp)
            .height(220.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(235.dp)
                    .height(145.dp)
            ) {
                GlideImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .clip(RoundedCornerShape(17.dp)),
                    model = item.thumbnail,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                if (item.has_discount) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(bottom = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_discount),
                                contentDescription = ""
                            )
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = item.discount,
                                    color = Color.White,
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }


                    }

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colorScheme.darkText,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "(۱ کیلو )",
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colorScheme.darkText,
                        fontWeight = FontWeight.Bold
                    )

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (item.has_discount) {
                            Text(
                                text = pastryByLocateAndSeparator((item.price / 10).toString()),
                                color = Color.LightGray,
                                textDecoration = TextDecoration.LineThrough,
                                style = MaterialTheme.typography.body1,
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                        }

                        Text(
                            text = " ${pastryByLocateAndSeparator((item.sale_price / 10).toString())} ${"تومان"}",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.darkText

                        )

                    }
                    IconButton(
                        modifier = Modifier.size(40.dp),
                        onClick = {
                            Log.e("pasi",item.ID.toString())
                        }) {
                        Icon(
                            painterResource(id = R.drawable.ic_shopingcard),
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier.size(35.dp, 25.dp)
                        )
                    }


                }

            }


        }

    }

}