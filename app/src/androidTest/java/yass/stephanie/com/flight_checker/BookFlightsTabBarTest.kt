package yass.stephanie.com.flight_checker

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class BookFlightsTabBarTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Espresso.onView(ViewMatchers.withId(R.id.navigation_find_flights)).perform(click())
    }

    @Test
    fun verifyBookFlightsHeaderIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.book_flights_header)).check(matches(isDisplayed()))
    }

    @Test
    fun verifyBookFlightsTabBarIsVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.book_flights_tab_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun verifyBookFlightsUpperTabBarIsVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.book_flights_tab_layout)).check(matches(isDisplayed()))
    }


}
