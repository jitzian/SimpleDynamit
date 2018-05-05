package test.platzi.com.raian.com.org.simpledynamit.ui.fragments

import android.support.v4.app.Fragment


open class BaseFragment: Fragment(){
    private var TAG = BaseFragment::class.java.simpleName
    open fun initializeFragmentViews() {}
}