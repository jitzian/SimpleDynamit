package test.platzi.com.raian.com.org.simpledynamit.test.platzi.com.raian.com.org.simpledynamit.ui.activity

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertTrue
import test.platzi.com.raian.com.org.simpledynamit.authentication.IAuthenticatorImpl

//@RunWith(JUnitPlatform::class)
class MainActivityTest: Spek({
    val customAuthenticator = IAuthenticatorImpl()
    given("User = user and password = password"){
        it("Should be true"){
            assertTrue(customAuthenticator.validateCredentials("user", "password"))
        }
    }

})