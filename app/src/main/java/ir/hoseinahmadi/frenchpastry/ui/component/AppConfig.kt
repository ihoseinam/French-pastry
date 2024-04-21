package ir.hoseinahmadi.frenchpastry.ui.component

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ir.hoseinahmadi.frenchpastry.util.Constants.CHECKED_LOGIN
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
    datastore.saveUserLogin(CHECKED_LOGIN)

}


