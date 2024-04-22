package ir.hoseinahmadi.frenchpastry.util

import ir.hoseinahmadi.frenchpastry.BuildConfig

object Constants {
    const val TIMEOUT_IN_SECOND: Long = 60
    const val BASE_URL = "https://pastry.alirezaahmadi.info/api/"
    const val DATASTORE_NAME = "dstore_name"
    const val KEY = BuildConfig.KEY
    const val IV = BuildConfig.IV

    var CHECKED_LOGIN = false
    var USER_PHONE = ""

}