package test.platzi.com.raian.com.org.simpledynamit.ui.activity.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import test.platzi.com.raian.com.org.simpledynamit.R
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpledynamit.model.country.Result
import test.platzi.com.raian.com.org.simpledynamit.model.country.ResultOpenAQCountry
import test.platzi.com.raian.com.org.simpledynamit.providers.RetrofitProvider
import test.platzi.com.raian.com.org.simpledynamit.rest.RestService
import test.platzi.com.raian.com.org.simpledynamit.utility.Utility

class InitialWelcomeFragment : Fragment() {
    private val TAG =  InitialWelcomeFragment::class.java.simpleName

    private lateinit var rootView: View
    private var mSpinnerCities: Spinner? = null

    private var retrofit : Retrofit? = null
    private var restService : RestService? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_initial_welcome, container, false)

        initializeView()
        initRetrofit()
        loadCountries()

        // Set an on item selected listener for spinner object
        mSpinnerCities?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view

            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }

        return rootView
    }

    private fun initializeView(){
        mSpinnerCities = rootView.findViewById(R.id.mSpinnerCities)
    }

    private fun initRetrofit(){
        retrofit = RetrofitProvider.getInstance().providesRetrofit(GlobalConstants.BASE_URL_OPEN_AQ)
        restService = retrofit?.create(RestService::class.java)!!
    }


    private fun loadCountries(){
        restService?.getAllCountries()?.enqueue(object : Callback<ResultOpenAQCountry>{
            override fun onResponse(call: Call<ResultOpenAQCountry>?, response: Response<ResultOpenAQCountry>?) {
                Log.d(TAG, "onResponse::${response?.body()?.results}")
                initAdapterForCountries(true, response?.body()?.results)

            }

            override fun onFailure(call: Call<ResultOpenAQCountry>?, t: Throwable?) {
                Log.e(TAG, "onFailure")
            }
        })
    }

    private fun initAdapterForCountries(dataFetched: Boolean, lstRes: List<Result>?){
        if(dataFetched) {
            lstRes?.let {
                val mUtility = Utility()
                val valuesToDisplay = mUtility.getArrayOfStringsFromResultOpenAQCountry("name", it)
                val mSpinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, valuesToDisplay)

                // Set the drop down view resource
                mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                activity?.runOnUiThread(java.lang.Runnable {
                    // Finally, data bind the spinner object with adapter
                    mSpinnerCities?.adapter = mSpinnerAdapter
                })
            }

        }
    }

}