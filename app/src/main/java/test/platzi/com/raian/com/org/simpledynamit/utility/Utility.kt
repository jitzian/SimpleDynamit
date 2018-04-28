package test.platzi.com.raian.com.org.simpledynamit.utility

import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpledynamit.model.country.Result

class Utility{
    fun getArrayOfStringsFromResultOpenAQCountry(field: String, lstRes: List<Result>): ArrayList<String> {
        val arrayToReturn = arrayListOf(GlobalConstants.DEFAULT_OPTION_FOR_SELECT)
        when(field){
            "name".toLowerCase()->{
                for(i in lstRes){
                    arrayToReturn.add(i.name)
                }
            }
            "code".toLowerCase()->{
                for(i in lstRes){
                    arrayToReturn.add(i.code)
                }
            }
            "cities".toLowerCase()->{
                for(i in lstRes){
                    arrayToReturn.add(i.cities.toString())
                }
            }
            "locations".toLowerCase()->{
                for(i in lstRes){
                    arrayToReturn.add(i.locations.toString())
                }
            }
            "count".toLowerCase()->{
                for(i in lstRes){
                    arrayToReturn.add(i.count.toString())
                }
            }
        }
        return arrayToReturn
    }
}