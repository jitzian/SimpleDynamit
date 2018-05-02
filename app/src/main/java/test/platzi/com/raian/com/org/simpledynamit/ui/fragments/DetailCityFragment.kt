package test.platzi.com.raian.com.org.simpledynamit.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import test.platzi.com.raian.com.org.simpledynamit.R
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants

private val CITY_PARAM = null
private val COUNTRY_PARAM = null
private val COUNT_PARAM = null

class DetailCityFragment : BaseFragment() {
    private val TAG = DetailCityFragment::class.java.simpleName

    private var city: String? = null
    private var country: String? = null
    private var count: String? = null

    private lateinit var rootView: View
    private lateinit var mImageViewHeaderCityDetail: ImageView
    private lateinit var mTextViewDetailCountry: TextView
    private lateinit var mTextViewDetailCity: TextView
    private lateinit var mTextViewDetailCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            city = it.getString(CITY_PARAM)
            country = it.getString(COUNTRY_PARAM)
            count = it.getString(COUNT_PARAM)

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_detail_city, container, false)

        initializeFragmentViews()
        return rootView
    }

    override fun initializeFragmentViews() {
        mImageViewHeaderCityDetail = rootView.findViewById(R.id.mImageViewHeaderCityDetail)
        mTextViewDetailCountry = rootView.findViewById(R.id.mTextViewDetailCountry)
        mTextViewDetailCity = rootView.findViewById(R.id.mTextViewDetailCity)
        mTextViewDetailCount = rootView.findViewById(R.id.mTextViewDetailCount)

        Picasso.with(this@DetailCityFragment.context)
                .load(GlobalConstants.URL_IMAGE_URL)
                .into(mImageViewHeaderCityDetail)

        mTextViewDetailCountry.text = country
        mTextViewDetailCity.text = city
//        mTextViewDetailCount.text = count

    }

    companion object {
        fun newInstance(city: String?, country: String?, count: String?) =
                DetailCityFragment().apply {
                    arguments = Bundle().apply {
                        putString(CITY_PARAM, city)
                        putString(COUNTRY_PARAM, country)
                        putString(COUNT_PARAM, count)
                    }
                }
    }

}
