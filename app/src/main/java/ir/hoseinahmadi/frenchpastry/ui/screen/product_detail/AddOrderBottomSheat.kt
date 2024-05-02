package ir.hoseinahmadi.frenchpastry.ui.screen.product_detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

var showAddOrder = mutableStateOf(false)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddOrderBottomSheet() {

    val show by remember {
        showAddOrder
    }
    if (show) {
        ModalBottomSheet(
            containerColor = Color.White,
            onDismissRequest = { showAddOrder.value = false })
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .weight(0.40f)
                            .padding(horizontal = 5.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(1.dp, Color.LightGray,RoundedCornerShape(12.dp)),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Green,
                                unselectedColor = Color.DarkGray
                            ),
                            selected = true, onClick = { /*TODO*/ })
                        Text(text = "سفارش عادی")

                    }

                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .weight(0.40f)
                            .padding(horizontal = 5.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(1.dp, Color.LightGray,RoundedCornerShape(12.dp)),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        RadioButton(
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Green,
                                unselectedColor = Color.DarkGray
                            ),
                            selected = false, onClick = { /*TODO*/ })

                        Text(text = "سفارش عمده")

                    }
                }
            }
        }
    }


}