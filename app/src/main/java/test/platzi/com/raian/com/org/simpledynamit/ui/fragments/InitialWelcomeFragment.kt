package test.platzi.com.raian.com.org.simpledynamit.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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
import test.platzi.com.raian.com.org.simpledynamit.adapters.RVCustomAdapter
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpledynamit.model.city.ResultOpenAQCity
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

    private lateinit var mRecyclerViewCities: RecyclerView
    private lateinit var rvAdapter: RVCustomAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_initial_welcome, container, false)

        initializeView()
        initRetrofit()
        loadCountries()
        loadCities()

        // Set an on item selected listener for spinner object
        mSpinnerCities?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                Log.e(TAG, "onItemSelected:: $position, $id")
                //TODO: Implement logic to filter the RV whenever the option is selected
            }
            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }
        return rootView
    }

    private fun initializeView(){
        mSpinnerCities = rootView.findViewById(R.id.mSpinnerCities)
        mRecyclerViewCities = rootView.findViewById(R.id.mRecyclerViewCities)

        //RecyclerView Initialization
        mRecyclerViewCities.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        mRecyclerViewCities.layoutManager = layoutManager
    }

    private fun initRetrofit(){
        retrofit = RetrofitProvider.getInstance().providesRetrofit(GlobalConstants.BASE_URL_OPEN_AQ)
        restService = retrofit?.create(RestService::class.java)!!
    }

    private fun loadCountries(){
        Runnable {
            restService?.getAllCountries()?.enqueue(object : Callback<ResultOpenAQCountry>{
                override fun onResponse(call: Call<ResultOpenAQCountry>?, response: Response<ResultOpenAQCountry>?) {
                    Log.d(TAG, "getAllCountries()::onResponse::${response?.body()?.results}")
                    initAdapterForCountries(true, response?.body()?.results)
                }
                override fun onFailure(call: Call<ResultOpenAQCountry>?, t: Throwable?) {
                    Log.e(TAG, "getAllCountries()::onFailure::${t?.message}")
                }
            })
        }.run()
    }

    private fun loadCities(){
        Runnable {
            restService?.getAllCities()?.enqueue(object : Callback<ResultOpenAQCity>{
                override fun onResponse(call: Call<ResultOpenAQCity>?, response: Response<ResultOpenAQCity>?) {
                    Log.d(TAG, "getAllCities()::onResponse::${response?.body()?.results?.size}")
                    Log.e(TAG, "-->> ${Utility.getInstance().filterCitiesAccordingMeasures(GlobalConstants.MEASUREMENTS_FILTER, response?.body()?.results?.toMutableList())?.size}")

                    rvAdapter = context?.let {
                        RVCustomAdapter(response?.body()?.results, it, fragmentManager)
                    }!!
                    rvAdapter.let {
                        activity?.runOnUiThread {
                            mRecyclerViewCities.adapter = rvAdapter
                        }
                    }
                }

                override fun onFailure(call: Call<ResultOpenAQCity>?, t: Throwable?) {
                    Log.e(TAG, "getAllCities()::onFailure::${t?.message}")

                }
            })
        }.run()
    }

    private fun initAdapterForCountries(dataFetched: Boolean, lstRes: List<Result>?){
        if(dataFetched) {
            lstRes?.let {
                val valuesToDisplay = Utility.getInstance().getArrayOfStringsFromResultOpenAQCountry("name", it)
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
