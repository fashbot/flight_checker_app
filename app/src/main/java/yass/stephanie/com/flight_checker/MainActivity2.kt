package yass.stephanie.com.flight_checker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import yass.stephanie.com.flight_checker.ui.mainactivity2.FindFlightsFragment

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FindFlightsFragment.newInstance())
                .commitNow()
        }
    }

}
