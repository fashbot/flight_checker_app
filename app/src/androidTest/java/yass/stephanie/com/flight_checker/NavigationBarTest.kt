package yass.stephanie.com.flight_checker

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class NavigationBarTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun verifyFlightFinderIsOnHomeScreenNavigation() {
        onView(withId(R.id.navigation_find_flights)).perform(click())
    }

    @Test
    fun verifyFavouriteFlightsIsOnHomeScreenNavigation() {
        onView(withId(R.id.navigation_favourite_flights)).perform(click())
    }

    @Test
    fun verifyMyFlightsIsOnHomeScreenNavigation() {
        onView(withId(R.id.navigation_my_flights)).perform(click())
    }

}
