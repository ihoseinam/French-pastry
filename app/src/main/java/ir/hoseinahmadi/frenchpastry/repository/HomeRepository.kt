package ir.hoseinahmadi.frenchpastry.repository

import ir.hoseinahmadi.frenchpastry.data.model.home.HomeResponse
import ir.hoseinahmadi.frenchpastry.data.remote.HomeApiInterFace
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiInterFace: HomeApiInterFace
) {

    val main = MutableStateFlow<HomeResponse>(HomeResponse())

    suspend fun getMain() {
        val response = try {
            apiInterFace.getMain()
        } catch (e: Exception) {
            return
        }
        if (response.isSuccessful){
            val body =response.body()
            body?.let {
                main.emit(it)
            }
        }


    }


}