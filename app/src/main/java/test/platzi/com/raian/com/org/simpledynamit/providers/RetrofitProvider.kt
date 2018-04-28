package test.platzi.com.raian.com.org.simpledynamit.providers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants
import java.util.concurrent.Executors

class RetrofitProvider private constructor(){
    companion object {
        private val retrofitProviderInstance = RetrofitProvider()

        @Synchronized
        fun getInstance(): RetrofitProvider{
            return retrofitProviderInstance
        }
    }

    fun providesRetrofit(baseURL: String?) : Retrofit{
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .baseUrl(baseURL)
                .build()
    }

}