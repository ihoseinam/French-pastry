package ir.hoseinahmadi.frenchpastry.ui.screen.product_detail.comment

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.gson.Gson
import ir.hoseinahmadi.frenchpastry.R
import ir.hoseinahmadi.frenchpastry.data.model.product_detail.Comment
import ir.hoseinahmadi.frenchpastry.navigation.Screen
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.ui.theme.body2
import ir.hoseinahmadi.frenchpastry.ui.theme.h5
import ir.hoseinahmadi.frenchpastry.ui.theme.h6
import ir.hoseinahmadi.frenchpastry.util.PastryHelper

@Composable
fun TextCommentCard(
    navHostController: NavHostController,
    item: Comment
) {

    Column(
        modifier = Modifier
            .padding(
                horizontal = 10.dp
            )
            .background(Color.White)
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 5.dp
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 8.dp,
                    vertical = 4.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )

            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text =PastryHelper.pastryByLocate("${item.rate}${".0"}"),
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "",
                    Modifier.size(15.dp),
                    tint = Color(0xffFFC700)
                )
            }
        }
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = PastryHelper.pastryByLocate(item.date_i18n),
            style = MaterialTheme.typography.h6,
            color = Color.DarkGray,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xffF2F7FD)),
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = item.body,
                style = MaterialTheme.typography.body2,
                color = Color(0xff555353),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 12.dp
                    )
                ) {
                    HorizontalDivider(
                        modifier = Modifier.padding(8.dp),
                        thickness = 1.dp,
                        color = Color.LightGray.copy(0.6f)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "این نظر برای شما مفید بود؟",
                            style = MaterialTheme.typography.h6,
                            color = Color(0xff555353)
                        )

                        Row {
                            IconButton(
                                modifier = Modifier.size(22.dp),
                                onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.like),
                                    contentDescription = "",
                                    Modifier.size(19.dp),
                                    tint = Color(0xff706C6C)

                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(
                                modifier = Modifier.size(22.dp),
                                onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.dislike),
                                    contentDescription = "",
                                    Modifier.size(19.dp),
                                    tint = Color(0xff706C6C)

                                )
                            }
                        }
                    }
                }

            }


        }
        if (item.replies != null){
            TextButton(
                modifier = Modifier.align(Alignment.Start),
                onClick = {
                    val data =Gson().toJson(item)
                    navHostController.navigate(Screen.CommentAndReplies.route +"?data=$data")
                }) {
                Text(
                    text = "مشاهده پاسخ ها",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}