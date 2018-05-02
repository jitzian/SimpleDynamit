package test.platzi.com.raian.com.org.simpledynamit.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import test.platzi.com.raian.com.org.simpledynamit.R
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailCityFragment : BaseFragment() {
    private val TAG = DetailCityFragment::class.java.simpleName

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var rootView: View
    private lateinit var mImageViewHeaderCityDetail: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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
        Picasso.with(this@DetailCityFragment.context)
                .load(GlobalConstants.URL_DETAIL_CITY_IMAGE_URL)
                .into(mImageViewHeaderCityDetail)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
                DetailCityFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }

    }

}
