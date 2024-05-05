package ir.hoseinahmadi.frenchpastry.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hoseinahmadi.frenchpastry.data.model.addres.addredResponse
import ir.hoseinahmadi.frenchpastry.repository.AddressRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(
    private val repository: AddressRepository
) : ViewModel() {

    val allAddress: Flow<addredResponse> = repository.allAddress
    val resultAddAddress = repository.resultAddAddress
    val loading =repository.loading

    fun getAllAddress(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllAddress(context)
        }
    }

     fun addAddress(
        context: Context,
        address: String,
        receiver: String,
        phone: String,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAddress(
                context,
                address = address,
                receiver = receiver,
                phone = phone
            )
        }
    }

     fun deleteOrder(
        context: Context,
        id:String
    ){
         viewModelScope.launch(Dispatchers.IO) {
             repository.deleteOrder(context,id)
         }
     }

}