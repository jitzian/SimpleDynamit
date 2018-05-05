package test.platzi.com.raian.com.org.simpledynamit.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import test.platzi.com.raian.com.org.simpledynamit.R
import test.platzi.com.raian.com.org.simpledynamit.authentication.IAuthenticator
import test.platzi.com.raian.com.org.simpledynamit.authentication.IAuthenticatorImpl
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants

class MainActivity : BaseActivity() {
    private var TAG = MainActivity::class.java.simpleName

    private lateinit var mEditTextUsername: EditText
    private lateinit var mEditTextPassword: EditText
    private lateinit var mButtonSignIn: Button
    private lateinit var customAuthenticator : IAuthenticator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        customAuthenticator = IAuthenticatorImpl(this@MainActivity)

        mButtonSignIn.setOnClickListener({

            if(customAuthenticator.validateInputUserNameLength(mEditTextUsername.text.toString())
                    && customAuthenticator.validateInputPasswordLength(mEditTextPassword.text.toString())){
                customAuthenticator.validateCredentialsOnRemoteAPI(mEditTextUsername.text?.toString(), mEditTextPassword.text?.toString())
            }

//            if(!mEditTextUsername.text?.isEmpty()!! && !mEditTextPassword.text?.isEmpty()!!){
//                when(customAuthenticator.validateInputUserNameLength(mEditTextUsername.text.toString())
//                        && customAuthenticator.validateInputPasswordLength(mEditTextPassword.text.toString())){
//
////                }
////                when(customAuthenticator.validateCredentials(mEditTextUsername.text?.toString(), mEditTextPassword.text?.toString())){
//                    true -> {
//                        customAuthenticator.validateCredentialsOnRemoteAPI(mEditTextUsername.text?.toString(), mEditTextPassword.text?.toString())
//                        Log.d(TAG, "Valid credentialas")
////                        customAuthenticator.redirectToAuthenticatedActivity(this@MainActivity)
//                    }
//                    false -> {
//                        Log.e(TAG, "Invalid credentialas")
//                        Toast.makeText(this@MainActivity, GlobalConstants.ERROR_CREDENTIALS_INVALID, Toast.LENGTH_LONG).show()
//                    }
//                }
//            }else{
//                Toast.makeText(this@MainActivity, GlobalConstants.INPUT_CREDENTIALS_ERROR, Toast.LENGTH_LONG).show()
//            }
        })
    }

    override fun initializeView() {
        mEditTextUsername = findViewById(R.id.mEditTextUsername)
        mEditTextPassword = findViewById(R.id.mEditTextPassword)
        mButtonSignIn = findViewById(R.id.mButtonSignIn)
    }


}
