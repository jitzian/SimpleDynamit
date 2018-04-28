package test.platzi.com.raian.com.org.simpledynamit.authentication

import android.content.Context

interface IAuthenticator{
    fun validateCredentials(uss: String?, pss: String?):Boolean
    fun executeAuthentication(context: Context?)
}