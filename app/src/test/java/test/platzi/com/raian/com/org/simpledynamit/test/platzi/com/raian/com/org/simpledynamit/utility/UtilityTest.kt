package test.platzi.com.raian.com.org.simpledynamit.test.platzi.com.raian.com.org.simpledynamit.utility

import junit.framework.Assert
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants.Companion.DEFAULT_OPTION_FOR_SELECT
import test.platzi.com.raian.com.org.simpledynamit.model.city.Result
import test.platzi.com.raian.com.org.simpledynamit.utility.Utility

class UtilityTest:Spek({

    given("Utility class is a Singleton"){
        it("Whenever getting the instance it should not be null"){
            Assert.assertNotNull(Utility.getInstance())
        }
    }

    given("A mocked list of Cities"){
        val lstRes = mutableListOf(
                Result("Richards Bay", "ZA", 11, 531),
                Result("Pristina", "XK", 1, 511),
                Result("unused", "AD", 1, 5320)
        )
        it("Will return only those cities with less thatn 10,000 measurements"){
            Assert.assertEquals(0, (Utility.getInstance().filterCitiesAccordingMeasures(GlobalConstants.MEASUREMENTS_FILTER, lstRes))?.size)
        }
    }

    given("A list of all the available countries from API and providing the field of query"){
        val listOfCountries = mutableListOf(
                test.platzi.com.raian.com.org.simpledynamit.model.country
                        .Result("United States", "US", 751, 1968, 29632318),
                test.platzi.com.raian.com.org.simpledynamit.model.country
                        .Result("Chile", "CL", 138, 113, 4570793),
                test.platzi.com.raian.com.org.simpledynamit.model.country
                        .Result("France", "FR", 135, 1174, 8186164)
        )

        it("Create a List of Strings by Country -name- to Populate SPinner on Welcome Fragment"){
            val filterType = "name"
            val arrayToReturn = Utility.getInstance().getArrayOfStringsFromResultOpenAQCountry(filterType,listOfCountries)
            val firstCountry = "United States"
            val secondCountry = "Chile"
            val thirdCountry = "France"
            Assert.assertEquals(arrayToReturn[0], DEFAULT_OPTION_FOR_SELECT)
            //TODO keep implementing for each case of filtering..
        }
    }

})