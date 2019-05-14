package yass.stephanie.com.flight_checker.ui.findfragment

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import yass.stephanie.com.flight_checker.R

class BookFlightsTabAdapter(fm: FragmentManager?, context: Context) : FragmentStatePagerAdapter(fm) {

    private val mContext: Context = context

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> RoundTripFragment()
            1 -> OneWayFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> mContext.getString(R.string.round_trip)
            1 -> mContext.getString(R.string.one_way)
            else -> null
        }
    }


}