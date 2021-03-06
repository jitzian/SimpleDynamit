package test.platzi.com.raian.com.org.simpledynamit.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
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
import test.platzi.com.raian.com.org.simpledynamit.ui.transition.DetailActivity

class RVCustomAdapter (private var lstRes: List<Result>?, private val context: Context) :
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
                it.setOnClickListener({
                    Log.d(TAG, "You've clicked: City: ${it.mTextViewCityValue}")

                    val mImageViewCityPair: Pair<View, String> = Pair.create(itemView.mImageViewCity, "mImageViewHeaderCityDetailTransition")

                    val intent = Intent(context, DetailActivity::class.java)

                    intent.putExtra("CITY_PARAM", mTextViewCityValue.text)
                    intent.putExtra("COUNTRY_PARAM", mTextViewCountryValue.text)
                    intent.putExtra("COUNT_PARAM", mTextViewCountValue.text)

                    val options:ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(it.context as Activity, mImageViewCityPair)
                    context.startActivity(intent, options.toBundle())
                })
            }
        }
    }

    fun filterList(filteredProductByName: ArrayList<Result>) {
        lstRes = filteredProductByName
        notifyDataSetChanged()
    }

}