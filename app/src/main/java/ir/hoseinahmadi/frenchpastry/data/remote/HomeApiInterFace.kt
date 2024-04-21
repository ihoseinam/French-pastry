package ir.hoseinahmadi.frenchpastry.data.remote

import ir.hoseinahmadi.frenchpastry.data.model.home.HomeResponse
import ir.hoseinahmadi.frenchpastry.data.model.login.SendCodeResponse
import ir.hoseinahmadi.frenchpastry.data.model.login.VerifyCodeResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface HomeApiInterFace {

    @GET("v1/main")
    suspend fun getMain():Response<HomeResponse>
    @FormUrlEncoded
    @POST("v1/auth/phone/login")
    suspend fun sendCodeWithEmail(
        @Header("app-device-uid")deviceId:String="8f1e64ec25bb70a3",
        @Header("app-public-key")publicId:String="e12d805050d03fa9410a6fba3bef6003",
        @Field("phone") phone:String
    ):Response<SendCodeResponse>
    @FormUrlEncoded
    @POST("v1/auth/phone/login/verify")
    suspend fun verifyCode(
        @Header("app-device-uid")deviceId:String="8f1e64ec25bb70a3",
        @Header("app-public-key")publicId:String="e12d805050d03fa9410a6fba3bef6003",
        @Field("code") code:String,
        @Field("phone") phone:String,
    ):Response<VerifyCodeResponse>


}