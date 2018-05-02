package test.platzi.com.raian.com.org.simpledynamit.test.platzi.com.raian.com.org.simpledynamit.authentication

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert
import org.junit.Assert.assertFalse
import test.platzi.com.raian.com.org.simpledynamit.authentication.IAuthenticatorImpl

class IAuthenticatorImplTest:Spek({
    val customAuthenticator = IAuthenticatorImpl()

    given("User input parameter = user and password input parameter = password"){
        val uss = "user"
        val pss = "password"
        it("Response should be true"){
            Assert.assertTrue(customAuthenticator.validateCredentials(uss, pss))
        }
    }

    given("User input parameter different of 'user' and password input parameter different of 'password'"){
        val uss = "otherUser"
        val pss = "everythingButPassword"
        it("Response shoould be false"){
            assertFalse(customAuthenticator.validateCredentials(uss, pss))
        }
    }

})