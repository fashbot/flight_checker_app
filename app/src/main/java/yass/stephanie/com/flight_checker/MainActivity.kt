package yass.stephanie.com.flight_checker

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.widget.TableLayout
import kotlinx.android.synthetic.main.activity_main.*
import yass.stephanie.com.flight_checker.favouriteFlights.FavouriteFlights
import yass.stephanie.com.flight_checker.myflights.MyFlightsFragment
import yass.stephanie.com.flight_checker.ui.findfragment.BookFlightsTabAdapter
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
                openFragment(myFlightsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_find_flights -> {
                openFragment(findFlightsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favourite_flights -> {
                openFragment(favouriteFlights)
                return@OnNavigationItemSelectedListener true
            }
        }
        fm.commit()
        false
    }


    private fun openFragment(fragment: Fragment) {
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
