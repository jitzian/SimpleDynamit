package test.platzi.com.raian.com.org.simpledynamit.model.city

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultOpenAQCity {

    @SerializedName("meta")
    @Expose
    var meta: Meta? = null
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null

}
