package ir.hoseinahmadi.frenchpastry.repository

import android.util.Log
import ir.hoseinahmadi.frenchpastry.data.model.product_detail.ProductResponse
import ir.hoseinahmadi.frenchpastry.data.remote.ProductDetailApiInterFace
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductDetailRepository @Inject constructor(
    private val apiInterFace: ProductDetailApiInterFace
) {
    val productItem = MutableStateFlow(ProductResponse())
    suspend fun getProductByID(id: Int) {
        withContext(Dispatchers.IO) {
            try {
                val response = apiInterFace.getProductById(id)
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        productItem.emit(it)
                    }
                } else {
                    Log.e("pasi", "getProductByID  notSuccess")
                }
            } catch (e: Exception) {
                Log.e("pasi", "getProductByID  error ${e.message}")
                return@withContext
            }
        }


    }
}
