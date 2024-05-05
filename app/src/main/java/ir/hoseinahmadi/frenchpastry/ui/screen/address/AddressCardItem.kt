package ir.hoseinahmadi.frenchpastry.ui.screen.address

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.hoseinahmadi.frenchpastry.R
import ir.hoseinahmadi.frenchpastry.data.model.addres.Addresse
import ir.hoseinahmadi.frenchpastry.data.model.addres.addredResponse
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.util.PastryHelper
import ir.hoseinahmadi.frenchpastry.viewModel.AddressViewModel

@Composable
fun AddressCardItem(
    item: Addresse,
    viewModel: AddressViewModel = hiltViewModel()
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 6.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .padding(top = 4.dp)
                .background(Color(0xffF4F6FF))
        ) {
            val context = LocalContext.current
            Icon(
                painter = painterResource(id = R.drawable.ic_message_edit),
                contentDescription = "",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                    },
                tint = Color.Black,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Icon(
                painter = painterResource(id = R.drawable.deleteorder),
                contentDescription = "",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        viewModel.deleteOrder(context, id = item.ID)
                    },
                tint = Color(0xffCF3C3C)
            )


        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f)
                .padding(end = 15.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                text = "گیرنده: ${item.receiver}  ",
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )

            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                text = "شماره همراه:  ${PastryHelper.pastryByLocate(item.phone)}",
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )

            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                text = "آدرس:  ${item.address}",
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )

        }
    }


}