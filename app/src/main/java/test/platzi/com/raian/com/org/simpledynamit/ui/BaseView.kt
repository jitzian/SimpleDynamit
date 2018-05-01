package test.platzi.com.raian.com.org.simpledynamit.ui

import test.platzi.com.raian.com.org.simpledynamit.model.country.Result

interface BaseView{
    fun initializeView()
    fun initRetrofit()
    fun loadCountries()
    fun loadCities()
    fun initAdapterForCountries(dataFetched: Boolean, lstRes: List<Result>?)

}