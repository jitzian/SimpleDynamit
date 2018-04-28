package test.platzi.com.raian.com.org.simpledynamit.model.city

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("locations")
    @Expose
    var locations: Int = 0
    @SerializedName("count")
    @Expose
    var count: Int = 0

}
