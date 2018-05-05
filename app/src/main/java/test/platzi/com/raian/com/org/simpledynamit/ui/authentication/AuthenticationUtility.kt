package test.platzi.com.raian.com.org.simpledynamit.ui.authentication

import android.util.Base64

fun encodeBase64ToServer(userName: String?, password:String?):String{

    val base : String? = "$userName:$password"
    println("encodeBase64ToServer::${base?.toByteArray()}")
    val authHeader : String? = "Basic ${Base64.encodeToString(base?.toByteArray(), Base64.NO_WRAP)}"
    return authHeader.toString()

}