package test.platzi.com.raian.com.org.simpledynamit.rest

import retrofit2.Call
import retrofit2.http.GET
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpledynamit.model.city.ResultOpenAQCity
import test.platzi.com.raian.com.org.simpledynamit.model.country.ResultOpenAQCountry

interface RestService {
    @GET("/v1/countries")
    fun getAllCountries() : Call<ResultOpenAQCountry>

    @GET("/v1/cities?limit=${GlobalConstants.OPEN_AQ_CITIES_LIMIT}&sort=desc")
    fun getAllCities() : Call<ResultOpenAQCity>
}