package com.example.uiappfinal

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


    @RunWith(AndroidJUnit4::class)
    @LargeTest
    class Test1 {

        @get:Rule
        val activityRule = ActivityScenarioRule(MainActivity::class.java)

        @Test
        fun useAppContext() {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            assertEquals("com.example.uiappfinal", appContext.packageName)
        }

        @Test
        fun testNavigationToFormActivity() {
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.fragmentFormContainer)).check(matches(isDisplayed()))
        }

        @Test
        fun testNavigationBackToMainActivity() {
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.formCreateButton)).perform(click())
            onView(withId(R.id.button)).check(matches(isDisplayed()))
        }
    }
