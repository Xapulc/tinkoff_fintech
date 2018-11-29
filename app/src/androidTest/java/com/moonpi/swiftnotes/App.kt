package com.moonpi.swiftnotes

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class App {
    fun checkText(id : Int, value : String) {
        onView(withText(id)).check(matches(ViewMatchers.withText(value)))
    }

    fun checkId(id : Int, value : String) {
        onView(withId(id)).check(matches(ViewMatchers.withHint(value)))
    }

    fun checkId(id: Int) {
        onView(withId(id)).check(matches(isDisplayed()))
    }

    fun clickId(id: Int) {
        onView(withId(id)).perform(click())
    }
}