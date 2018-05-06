package test.platzi.com.raian.com.org.simpledynamit.utility

import android.app.Activity
import android.widget.Toast
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpledynamit.model.country.Result

class Utility private constructor(){

    //Singleton threadsafe instace of Utility class
    companion object {
        private val mUtility = Utility()

        @Synchronized
        fun getInstance():Utility{
            return mUtility
        }
    }

    fun getArrayOfStringsFromResultOpenAQCountry(field: String, lstRes: List<Result>): ArrayList<String> {
        val arrayToReturn = arrayListOf(GlobalConstants.DEFAULT_OPTION_FOR_SELECT)
        when(field){
            "name".toLowerCase()->{
                for(i in lstRes){
                    i.name?.let { arrayToReturn.add(it) }
                }
            }
            "code".toLowerCase()->{
                for(i in lstRes){
                    i.code?.let { arrayToReturn.add(it) }
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

    fun filterCitiesAccordingMeasures(filterInput: Int, lstRes : MutableList<test.platzi.com.raian.com.org.simpledynamit.model.city.Result>?):
            List<test.platzi.com.raian.com.org.simpledynamit.model.city.Result>?{
        lstRes?.let {
            val lstIterator = lstRes.iterator()
            while(lstIterator.hasNext()){
                val count = lstIterator.next().count
                if(count < filterInput){
                    lstIterator.remove()
                }
            }
        }
        return lstRes?.sortedWith(compareBy ({ it.count }))
    }

    fun toast(activity: Activity, message: String){
        toast(activity, message, Toast.LENGTH_LONG)
    }

    fun toast(activity: Activity, message: String, duration: Int){
        var toast = Toast.makeText(activity, message, duration)
        toast.show()
    }
}