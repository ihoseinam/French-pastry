package ir.hoseinahmadi.frenchpastry.ui.screen.profile

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.gmail.hamedvakhide.compose_jalali_datepicker.JalaliDatePickerDialog
import ir.hoseinahmadi.frenchpastry.navigation.Screen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileScreen(
   navHostController: NavHostController
){
   Text(text ="ProfileScreen")

   Button(onClick = {
      navHostController.navigate(Screen.ProfileInfoScreen.route)
   }) {
      Text(text = "Open JalaliDatePicker")
   }



}

