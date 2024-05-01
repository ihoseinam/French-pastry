package ir.hoseinahmadi.frenchpastry.repository

import android.util.Log
import ir.hoseinahmadi.frenchpastry.data.model.userInfo.UserInfoResponse
import ir.hoseinahmadi.frenchpastry.data.remote.InfoUserInterFace
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.http.Field
import retrofit2.http.Header
import javax.inject.Inject

class UserInfoRepository @Inject constructor(
    private var api: InfoUserInterFace
) {

    var userInfo = MutableStateFlow<UserInfoResponse>(UserInfoResponse())
    var loading = MutableStateFlow(false)
    var userSendInfo =MutableStateFlow<UserInfoResponse>(UserInfoResponse())

    suspend fun getUserInfo(
        apiKey: String,
        deviceUid: String,
        publicKey: String,
    ) {
        loading.emit(true)
        val response = try {
            api.getUserInfo(
                apiKey = apiKey,
                deviceUid = deviceUid,
                publicKey = publicKey
            )
        } catch (e: Exception) {
            Log.e("pasi", "getUserInfo error : ${e.message}")
            return
        }
        if (response.isSuccessful) {
            val body = response.body()
            body?.let {
                userInfo.emit(it)
            }
            delay(700)
            loading.emit(false)
        }
    }


    suspend fun sendUserInfo(
         deviceUid: String,
         publicKey: String,
         apiKey: String,
         fullName:String,
         nationalCode:String,
         email:String,
         sex:String,
        birthdate:String,
    ){
        loading.emit(true)
        val response =try {
            api.sendUserInfo(
                deviceUid= deviceUid,
                publicKey= publicKey,
                apiKey= apiKey,
                fullName=fullName,
                nationalCode=nationalCode,
                email=email,
                sex=sex,
                birthdate=birthdate,
            )
        }catch (e:Exception){
            Log.e("pasi", "sendUserInfo error : ${e.message}")
            return
        }
        if (response.isSuccessful){
            loading.emit(false)
            val body =response.body()
            body?.let {
                userSendInfo.emit(it)
            }
        }

    }


}