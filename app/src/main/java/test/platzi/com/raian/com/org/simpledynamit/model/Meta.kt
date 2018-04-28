package test.platzi.com.raian.com.org.simpledynamit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meta {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("license")
    @Expose
    var license: String? = null
    @SerializedName("website")
    @Expose
    var website: String? = null
    @SerializedName("page")
    @Expose
    var page: Int = 0
    @SerializedName("limit")
    @Expose
    var limit: Int = 0
    @SerializedName("found")
    @Expose
    var found: Int = 0

}
