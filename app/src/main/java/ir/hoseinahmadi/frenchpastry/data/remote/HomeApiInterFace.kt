package ir.hoseinahmadi.frenchpastry.data.remote

import ir.hoseinahmadi.frenchpastry.data.model.home.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterFace {

    @GET("v1/main")
    suspend fun getMain():Response<HomeResponse>

}