package test.platzi.com.raian.com.org.simpledynamit.authentication

import android.content.Context
import android.content.Intent
import test.platzi.com.raian.com.org.simpledynamit.ui.activity.WelcomeActivity

class IAuthenticatorImpl: IAuthenticator{

    override fun validateCredentials(uss: String?, pss: String?):Boolean {
        var isValid = false
        if (uss != null && pss != null){
            isValid = !uss.isEmpty() && uss == "user" && !pss.isEmpty() && pss == "password"
        }
        return isValid
    }

    override fun executeAuthentication(context: Context?) {
        context?.startActivity(Intent(context, WelcomeActivity::class.java))
    }

}