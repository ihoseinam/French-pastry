package ir.hoseinahmadi.frenchpastry.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hoseinahmadi.frenchpastry.repository.HomeRepository
import ir.hoseinahmadi.frenchpastry.ui.screen.home.HomeScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    var userPhone by mutableStateOf("")
    var homeScreenState by mutableStateOf(HomeScreenState.LoginScreen)
    val mainResponse = repository.main

    suspend fun getMain() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMain()
        }
    }

    fun login() {
        viewModelScope.launch {

        }
    }
}