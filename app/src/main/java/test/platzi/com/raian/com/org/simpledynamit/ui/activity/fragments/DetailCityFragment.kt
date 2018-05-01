package test.platzi.com.raian.com.org.simpledynamit.ui.activity.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import test.platzi.com.raian.com.org.simpledynamit.R
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants

class DetailCityFragment : BaseFragment() {
    private val TAG = DetailCityFragment::class.java.simpleName

    private lateinit var rootView: View
    private lateinit var mImageViewHeaderCityDetail: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_detail_city, container, false)
        initializeFragmentViews()
        return rootView
    }

    override fun initializeFragmentViews() {
        mImageViewHeaderCityDetail = rootView.findViewById(R.id.mImageViewHeaderCityDetail)
        Picasso.with(this@DetailCityFragment.context)
                .load(GlobalConstants.URL_DETAIL_CITY_IMAGE_URL)
                .into(mImageViewHeaderCityDetail)
    }



}
