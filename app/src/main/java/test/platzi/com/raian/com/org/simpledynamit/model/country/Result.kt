package test.platzi.com.raian.com.org.simpledynamit.model.country

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("code")
    @Expose
    var code: String? = null
    @SerializedName("cities")
    @Expose
    var cities: Int = 0
    @SerializedName("locations")
    @Expose
    var locations: Int = 0
    @SerializedName("count")
    @Expose
    var count: Int = 0

}
