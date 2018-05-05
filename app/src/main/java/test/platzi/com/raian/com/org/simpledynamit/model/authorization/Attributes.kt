package test.platzi.com.raian.com.org.simpledynamit.model.authorization

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Attributes {
    @SerializedName("error")
    @Expose
    var error: String? = null
}
