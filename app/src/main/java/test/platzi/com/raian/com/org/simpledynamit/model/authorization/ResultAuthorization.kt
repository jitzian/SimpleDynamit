package test.platzi.com.raian.com.org.simpledynamit.model.authorization

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultAuthorization {
    @SerializedName("statusCode")
    @Expose
    var statusCode: String? = null
    @SerializedName("error")
    @Expose
    var error: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("attributes")
    @Expose
    var attributes: Attributes? = null
}
