package test.platzi.com.raian.com.org.simpledynamit.model.country

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultOpenAQCountry {

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null

}
