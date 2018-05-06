package test.platzi.com.raian.com.org.simpledynamit.authentication

import android.content.Context
import android.content.Intent
import android.os.Looper
import android.os.MessageQueue
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants.Companion.ERROR_ENTERED_CREDENTIALS_NOT_VALID
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants.Companion.STATUS_CODE_200
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants.Companion.STATUS_CODE_401
import test.platzi.com.raian.com.org.simpledynamit.model.authorization.ResultAuthorization
import test.platzi.com.raian.com.org.simpledynamit.providers.RetrofitProvider
import test.platzi.com.raian.com.org.simpledynamit.rest.RestService
import test.platzi.com.raian.com.org.simpledynamit.ui.activity.WelcomeActivity
import test.platzi.com.raian.com.org.simpledynamit.ui.authentication.encodeBase64ToServer

class IAuthenticatorImpl(val context: Context?): IAuthenticator{
    val TAG = IAuthenticatorImpl::class.java.simpleName

    override fun validateCredentials(uss: String?, pss: String?):Boolean {
        var isValid = false
        if (uss != null && pss != null){
            isValid = !uss.isEmpty() && uss == "user" && !pss.isEmpty() && pss == "password"
        }
        return isValid
    }

    override fun validateInputUserNameLength(userName: String?): Boolean {
        var isValidLength = false
        userName?.let {
            isValidLength = userName.isNotEmpty()
        }
        return isValidLength
    }

    override fun validateInputPasswordLength(password: String?): Boolean {
        var isValidLength = false
        password?.let {
            isValidLength = password.isNotEmpty()
        }
        return isValidLength
    }

    override fun redirectToAuthenticatedActivity(context: Context?) {
        val mWelcomeActivityIntent = Intent(context, WelcomeActivity::class.java)
        context?.startActivity(mWelcomeActivityIntent)
    }

    override fun validateCredentialsOnRemoteAPI(uss: String?, pss: String?){
        val authHeader = encodeBase64ToServer(uss, pss)
        Log.e(TAG, " -- $uss: $pss: $authHeader")
        val retrofit = RetrofitProvider.getInstance().providesRetrofit(GlobalConstants.baseURLAuthorization)
        val restService = retrofit.create(RestService::class.java)

        restService.getAuthorizationResponse(authHeader).enqueue(object : Callback<ResultAuthorization>{

            override fun onResponse(call: Call<ResultAuthorization>?, response: Response<ResultAuthorization>?) {
                Log.d(TAG, "Authentication succeedded: ${response?.body()?.statusCode}")
                response?.code().let {
                    when(it){
                        STATUS_CODE_200 -> {
                            redirectToAuthenticatedActivity(context)
                        }
                        STATUS_CODE_401 ->{
                            Log.e(TAG, "error:$it")
                            showToastOnWorkerThread(ERROR_ENTERED_CREDENTIALS_NOT_VALID)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResultAuthorization>?, t: Throwable?) {
                Log.e(TAG, "Autentication failed: ${t?.message}")

            }
        })
    }

    fun showToastOnWorkerThread(message: String) {
        val th = object : Thread() {
            override fun run() {
                println("Start Looper...")
                // Prepare looper
                Looper.prepare()

                // Register Queue listener hook
                val queue = Looper.myQueue()
                queue.addIdleHandler(object : MessageQueue.IdleHandler {
                    internal var mReqCount = 0

                    override fun queueIdle(): Boolean {
                        if (++mReqCount == 2) {
                            // Quit looper
                            Looper.myLooper()!!.quit()
                            return false
                        } else
                            return true
                    }
                })

                // Show Toast- will be called when Looper.loop() starts
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                // Start looping Message Queue- Blocking call
                Looper.loop()

                //TODO: Move this to Utility Toas class or something cool
                println("It appears after Looper.myLooper().quit()")
            }
        }
        th.start()
    }

}