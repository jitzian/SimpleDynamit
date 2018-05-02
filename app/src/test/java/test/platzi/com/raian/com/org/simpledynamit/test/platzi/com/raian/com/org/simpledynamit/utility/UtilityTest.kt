package test.platzi.com.raian.com.org.simpledynamit.test.platzi.com.raian.com.org.simpledynamit.utility

import junit.framework.Assert
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import test.platzi.com.raian.com.org.simpledynamit.utility.Utility

class UtilityTest:Spek({
    given("Utility class is a Singleton"){
        it("Whenever getting the instance it should not be null"){
            Assert.assertNotNull(Utility.getInstance())
        }
    }
})