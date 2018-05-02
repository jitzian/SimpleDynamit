package test.platzi.com.raian.com.org.simpledynamit.adapters

import android.content.Context
import android.support.transition.Fade
import android.support.transition.TransitionInflater
import android.support.transition.TransitionSet
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.city_card_view.view.*
import test.platzi.com.raian.com.org.simpledynamit.R
import test.platzi.com.raian.com.org.simpledynamit.constants.GlobalConstants
import test.platzi.com.raian.com.org.simpledynamit.model.city.Result
import test.platzi.com.raian.com.org.simpledynamit.ui.fragments.DetailCityFragment
import test.platzi.com.raian.com.org.simpledynamit.ui.fragments.InitialWelcomeFragment
import test.platzi.com.raian.com.org.simpledynamit.ui.transition.TransitionType

class RVCustomAdapter (private var lstRes: List<Result>?, private val context: Context, private var fragmentManager: FragmentManager?) :
        RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {
    private var TAG = RVCustomAdapter::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.city_card_view, parent, false))
    }

    override fun getItemCount(): Int {
        return if(lstRes?.size!! > 0){
            lstRes?.size!!
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextViewCityValue.text = lstRes?.get(position)?.city
        holder.mTextViewCountryValue.text = lstRes?.get(position)?.country
        holder.mTextViewCountValue.text = lstRes?.get(position)?.count.toString()
        Picasso.with(context)
                .load(GlobalConstants.URL_IMAGE_URL)
                .into(holder.mImageViewCity)
    }
    val FADE_DEFAULT_TIME = 300
    val MOVE_DEFAULT_TIME = 1000

    //ViewHolder
    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        //CardViewControls
        lateinit var mImageViewCity: ImageView
        lateinit var mTextViewCityValue: TextView
        lateinit var mTextViewCountryValue: TextView
        lateinit var mTextViewCountValue: TextView

        init{
            itemView?.let {
                mImageViewCity = it.findViewById(R.id.mImageViewCity)
                mTextViewCityValue = it.findViewById(R.id.mTextViewCityValue)
                mTextViewCountryValue = it.findViewById(R.id.mTextViewCountryValue)
                mTextViewCountValue = it.findViewById(R.id.mTextViewCountValue)
                it.setOnClickListener(View.OnClickListener {
                    Log.d(TAG, "You've clicked: City: ${it.mTextViewCityValue}")


//                    var nextFragment = DetailCityFragment.newInstance("", "")
//
//                    // 1. Exit for Previous Fragment
//                    var exitFade = Fade()
//
//                    exitFade.duration = FADE_DEFAULT_TIME.toLong()
//
//                    // 2. Shared Elements Transition
//                    var enterTransitionSet = TransitionSet()
//                    enterTransitionSet.addTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.move))
//                    enterTransitionSet.duration = MOVE_DEFAULT_TIME.toLong()
//                    enterTransitionSet.startDelay = FADE_DEFAULT_TIME.toLong()
//                    nextFragment.sharedElementEnterTransition = enterTransitionSet
//
//                    // 3. Enter Transition for New Fragment
//                    var enterFade = Fade()
//                    enterFade.startDelay = (MOVE_DEFAULT_TIME + FADE_DEFAULT_TIME).toLong()
//                    enterFade.duration = FADE_DEFAULT_TIME.toLong()
//                    nextFragment.setEnterTransition(enterFade)
//
////                    fragmentManager?.beginTransaction()?.replace(R.id.mFraLayoutWelcomeContainer, DetailCityFragment.newInstance("",""), DetailCityFragment::class.java.simpleName)?.commitNowAllowingStateLoss()
//                    fragmentManager?.beginTransaction()?.replace(R.id.mFrameLayoutMainContent, DetailCityFragment.newInstance("",""), DetailCityFragment::class.java.simpleName)?.commit()
//

//                    fragmentManager?.beginTransaction()
//                            .addToBackStack(InitialWelcomeFragment()::class.java.simpleName)
//                            .setCustomAnimations(1,2,3,4,)
//                            .replace()
//                            .

                })
            }
        }
    }

}