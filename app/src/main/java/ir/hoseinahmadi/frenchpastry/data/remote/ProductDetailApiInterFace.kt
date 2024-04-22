package ir.hoseinahmadi.frenchpastry.data.remote

import ir.hoseinahmadi.frenchpastry.data.model.home.HomeResponse
import ir.hoseinahmadi.frenchpastry.data.model.login.SendCodeResponse
import ir.hoseinahmadi.frenchpastry.data.model.login.VerifyCodeResponse
import ir.hoseinahmadi.frenchpastry.data.model.product_detail.ProductResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductDetailApiInterFace {

    @GET("v1/pastry/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ):Response<ProductResponse>


}