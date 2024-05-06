package ir.hoseinahmadi.frenchpastry.ui.screen.address

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import ir.hoseinahmadi.frenchpastry.ui.screen.product_detail.Header
import ir.hoseinahmadi.frenchpastry.ui.theme.LightCyan
import ir.hoseinahmadi.frenchpastry.ui.theme.amber
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.ui.theme.darkText
import ir.hoseinahmadi.frenchpastry.ui.theme.grayCategory
import ir.hoseinahmadi.frenchpastry.ui.theme.h6
import ir.hoseinahmadi.frenchpastry.util.InputValidation
import ir.hoseinahmadi.frenchpastry.util.PastryHelper
import ir.hoseinahmadi.frenchpastry.viewModel.AddressViewModel
import kotlinx.coroutines.flow.collectLatest

var showBottomSheetAddAddress = mutableStateOf(false)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetAddAddress(
    viewModel: AddressViewModel = hiltViewModel()
) {
    val show by remember {
        showBottomSheetAddAddress
    }

    if (show) {
        ModalBottomSheet(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp),
            containerColor = Color.White,
            onDismissRequest = { showBottomSheetAddAddress.value = false })
        {
            Header(title = "ثبت آدرس جدید")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 5.dp)
            ) {
                var check by remember {
                    mutableStateOf(false)
                }
                var name by remember {
                    mutableStateOf("")
                }
                var phone by remember {
                    mutableStateOf("")
                }
                var address by remember {
                    mutableStateOf("")
                }

                TextFieldAddAddress(
                    value = name,
                    onChangeValue = { name = it },
                    hint = "نام و نام خانوادگی گیرنده",
                    isError = check && name.length < 8
                )

                TextFieldAddAddress(
                    value = phone,
                    onChangeValue = { phone = it },
                    hint = "شماره همراه گیرنده",
                    isError = check && phone.length != 11,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    textDirection = TextDirection.Ltr
                )

                TextFieldAddAddress(
                    value = address,
                    onChangeValue = { address = it },
                    hint = "خیابان- کوچه-پلاک",
                    isError = check && address.length < 20,
                )

                val context = LocalContext.current

                Button(
                    shape = RoundedCornerShape(9.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    onClick = {
                        check = true
                        if (name.length < 8) {
                            Toast.makeText(context, "نام را ماکل تر وارد کنید", Toast.LENGTH_SHORT)
                                .show()
                        } else if (InputValidation.isValidPhoneNumber(phone)) {
                            Toast.makeText(context, "شماره تلفن صحیح نمی باشد", Toast.LENGTH_SHORT)
                                .show()
                        } else if (address.length < 20) {
                            Toast.makeText(context, "آدرس را کامل تر وارد کنید", Toast.LENGTH_SHORT)
                                .show()
                        } else if (phone.length==11) {
                            viewModel.addAddress(
                                context = context,
                                phone = phone,
                                address = address,
                                receiver = name
                            )
                            showBottomSheetAddAddress.value =false
                            viewModel.getAllAddress(context)
                        }else{
                            Toast.makeText(context, "فرمت شماره تلفن اشتباه می باشد", Toast.LENGTH_SHORT).show()

                        }

                    })
                {
                    Text(
                        text = "افزودن آدرس جدید",
                        style = MaterialTheme.typography.body1,
                        color = Color.White
                    )
                }


            }
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
        }
    }
}

@Composable
private fun TextFieldAddAddress(
    value: String,
    onChangeValue: (it: String) -> Unit,
    hint: String,
    isError: Boolean,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    textDirection: TextDirection = TextDirection.Rtl
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        value = PastryHelper.pastryByLocate(value),
        textStyle = MaterialTheme.typography.body1.copy(
            textDirection = textDirection
        ),
        keyboardOptions = keyboardOptions,
        placeholder = {
            Text(
                text = hint,
                color = Color.DarkGray,
                style = MaterialTheme.typography.h6

            )
        },
        isError = isError,
        onValueChange = { onChangeValue(it) },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.darkText,
            focusedContainerColor = MaterialTheme.colorScheme.grayCategory,
            unfocusedContainerColor = MaterialTheme.colorScheme.grayCategory,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.LightCyan,
            focusedIndicatorColor = MaterialTheme.colorScheme.LightCyan,
            errorTextColor = Color.Red,
        ),
        singleLine = true
    )
}