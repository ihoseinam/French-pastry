package ir.hoseinahmadi.frenchpastry.ui.component

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ir.hoseinahmadi.frenchpastry.util.Constants
import ir.hoseinahmadi.frenchpastry.util.Constants.API_KEY
import ir.hoseinahmadi.frenchpastry.util.Constants.CHECKED_LOGIN
import ir.hoseinahmadi.frenchpastry.util.Constants.USER_PHONE
import ir.hoseinahmadi.frenchpastry.viewModel.DatStoreViewModel
import ir.hoseinahmadi.frenchpastry.viewModel.HomeViewModel

@Composable
fun AppConfig(
    datStoreViewModel: DatStoreViewModel = hiltViewModel(),
) {
    getDatStoreVariables(datStoreViewModel)


}

fun getDatStoreVariables(datastore: DatStoreViewModel) {

    CHECKED_LOGIN = datastore.getUserLogin()

    USER_PHONE = datastore.getUserPhone()
    API_KEY = datastore.getUserApiKey()

}


