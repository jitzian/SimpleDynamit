package test.platzi.com.raian.com.org.simpledynamit.ui.transition

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import test.platzi.com.raian.com.org.simpledynamit.R
import test.platzi.com.raian.com.org.simpledynamit.ui.activity.BaseActivity
import test.platzi.com.raian.com.org.simpledynamit.ui.fragments.DetailCityFragment

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent?.extras?.let {
            var cityParam = it.getString("CITY_PARAM")
            var countryParam = it.getString("COUNTRY_PARAM")
            var countParam = it.getString("COUNT_PARAM")

            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.mFrameLayoutDetailCityContainer,
                            DetailCityFragment.newInstance(cityParam, countryParam, countParam),
                            DetailCityFragment::class.java.simpleName)
                    .commit()
        }
    }

    override fun initializeView() {}

}
