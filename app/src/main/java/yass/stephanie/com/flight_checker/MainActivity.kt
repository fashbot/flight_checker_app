package yass.stephanie.com.flight_checker

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*
import yass.stephanie.com.flight_checker.favouriteFlights.FavouriteFlights
import yass.stephanie.com.flight_checker.myflights.MyFlightsFragment
import yass.stephanie.com.flight_checker.ui.findfragment.FindFlightsFragment

class MainActivity : AppCompatActivity() {

    private var currentFragment: Int = R.id.main_view
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val fm: FragmentTransaction = supportFragmentManager.beginTransaction()
        val findFlightsFragment = FindFlightsFragment()
        val myFlightsFragment = MyFlightsFragment()
        val favouriteFlights = FavouriteFlights()

        when (item.itemId) {
            R.id.navigation_my_flights -> {
                openFragment(myFlightsFragment, R.id.my_flights_layout)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_find_flights -> {
                openFragment(findFlightsFragment, R.id.find_flights_layout)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favourite_flights -> {
                openFragment(favouriteFlights, R.id.favourite_flights_layout)
                return@OnNavigationItemSelectedListener true
            }
        }
        fm.commit()
        false
    }


    private fun openFragment(fragment: Fragment, heldFragment: Int) {
        val fm: FragmentTransaction = supportFragmentManager.beginTransaction();
        fm.replace(currentFragment, fragment)
        fm.addToBackStack(null)
        fm.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
