package test.platzi.com.raian.com.org.simpledynamit.test.test.platzi.com.raian.com.org.simpledynamit.authentication

import android.test.mock.MockContext
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import test.platzi.com.raian.com.org.simpledynamit.authentication.IAuthenticatorImpl

object IAuthenticatorImplTest:Spek({
    val authenticator by memoized { IAuthenticatorImpl(MockContext()) }

    given("Credentials user not empty"){
        val userName = "user"
        it("Will return true as valid user"){
            assertTrue(authenticator.validateInputUserNameLength(userName))
        }
    }

    given("Credentials user is empty"){
        val userName = ""
        it("Will return true as invalid user"){
            assertFalse(authenticator.validateInputUserNameLength(userName))
        }
    }

    given("Credentials password not empty"){
        val password = "password"
        it("Will return true as valid password"){
            assertTrue(authenticator.validateInputUserNameLength(password))

        }
    }

    given("Credentials password is empty"){
        val password = ""
        it("Will return true as invalid password"){
            assertFalse(authenticator.validateInputUserNameLength(password))
        }
    }

})