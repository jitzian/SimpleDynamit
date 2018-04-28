package test.platzi.com.raian.com.org.simpledynamit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coordinates {

    @SerializedName("latitude")
    @Expose
    var latitude: Double = 0.toDouble()
    @SerializedName("longitude")
    @Expose
    var longitude: Double = 0.toDouble()

}
