package test.platzi.com.raian.com.org.simpledynamit.authentication

import android.content.Context

interface IAuthenticator{
    fun validateInputUserNameLength(userName : String?):Boolean
    fun validateInputPasswordLength(password: String?):Boolean
    fun validateCredentials(uss: String?, pss: String?):Boolean
    fun validateCredentialsOnRemoteAPI(uss: String?, pss: String?)
    fun redirectToAuthenticatedActivity(context: Context?)
}