package test.platzi.com.raian.com.org.simpledynamit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultMeasurements {

    @SerializedName("location")
    @Expose
    var location: String? = null
    @SerializedName("parameter")
    @Expose
    var parameter: String? = null
    @SerializedName("date")
    @Expose
    var date: Date? = null
    @SerializedName("value")
    @Expose
    var value: Double = 0.toDouble()
    @SerializedName("unit")
    @Expose
    var unit: String? = null
    @SerializedName("coordinates")
    @Expose
    var coordinates: Coordinates? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null

}
