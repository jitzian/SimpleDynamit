package test.platzi.com.raian.com.org.simpledynamit.rest

import retrofit2.Call
import retrofit2.http.GET
import test.platzi.com.raian.com.org.simpledynamit.model.country.ResultOpenAQCountry

interface RestService {

    @GET("/v1/countries")
    fun getAllCountries() : Call<ResultOpenAQCountry>

}