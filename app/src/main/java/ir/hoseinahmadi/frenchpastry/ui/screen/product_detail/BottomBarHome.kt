package ir.hoseinahmadi.frenchpastry.ui.screen.product_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import ir.hoseinahmadi.frenchpastry.R
import ir.hoseinahmadi.frenchpastry.data.model.product_detail.Pastry
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.ui.theme.body2
import ir.hoseinahmadi.frenchpastry.ui.theme.darkText
import ir.hoseinahmadi.frenchpastry.ui.theme.h6
import ir.hoseinahmadi.frenchpastry.util.PastryHelper

@Composable
fun BottomBarHome(
    item: Pastry
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                horizontal = 6.dp,
                vertical = 7.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            shape = RoundedCornerShape(9.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
            onClick = { showAddOrder.value=true }) {
            Text(
                text = "افزودن به سبد خرید",
                style = MaterialTheme.typography.body2,
                color = Color.White
            )

        }

        Column(
            Modifier.padding(end = 6.dp),
            horizontalAlignment = Alignment.End,
        ) {
            if (item.has_discount) {
                Row(
                    Modifier.padding(end = 7.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color.Red,
                                shape = CircleShape
                            )
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .wrapContentHeight(Alignment.CenterVertically)
                    ) {
                        Text(
                            text =PastryHelper.pastryByLocate(item.discount_percent_110n) ,
                            style = MaterialTheme.typography.h6,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(
                                horizontal = 7.dp
                            )
                        )
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                    Text(
                        text = PastryHelper.pastryBySeparator(
                            "${
                                PastryHelper.applyDiscount(
                                    item.price.toLong(),
                                    item.discount_percent
                                )
                            }"
                        ),
                        style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                        textDecoration = TextDecoration.LineThrough
                    )


                }
            }

                Text(
                    text ="${PastryHelper.pastryByLocateAndSeparator(item.sale_price.toString())} تومان " ,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colorScheme.darkText,
                    fontWeight = FontWeight.SemiBold
                )




        }
    }
}