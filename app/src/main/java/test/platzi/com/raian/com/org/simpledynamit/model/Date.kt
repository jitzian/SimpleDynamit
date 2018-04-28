package test.platzi.com.raian.com.org.simpledynamit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Date {

    @SerializedName("utc")
    @Expose
    var utc: String? = null
    @SerializedName("local")
    @Expose
    var local: String? = null

}
