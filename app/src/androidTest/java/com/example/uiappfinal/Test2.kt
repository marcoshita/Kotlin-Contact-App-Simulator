package com.example.uiappfinal

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.PositionAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class Test2 {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun posicionsMainActivity(){
        //Title is above the other elements
        onView(withId(R.id.textView)).check(PositionAssertions.isAbove(withId(R.id.textView2)))
        onView(withId(R.id.textView)).check(PositionAssertions.isAbove(withId(R.id.button)))
        onView(withId(R.id.textView)).check(PositionAssertions.isAbove(withId(R.id.rv_list)))

        //Contacts text is above rv list and under title
        onView(withId(R.id.textView2)).check(PositionAssertions.isAbove(withId(R.id.rv_list)))
        onView(withId(R.id.textView2)).check(PositionAssertions.isBelow(withId(R.id.textView)))

        //Rv list is under all elements
        onView(withId(R.id.rv_list)).check(PositionAssertions.isBelow(withId(R.id.textView)))
        onView(withId(R.id.rv_list)).check(PositionAssertions.isBelow(withId(R.id.textView2)))
        //onView(withId(R.id.rv_list)).check(PositionAssertions.isBelow(withId(R.id.button)))
    }


    @Ignore
    @Test
    fun posicionsFallen() {
        //He movido las posiciones del boton para que no este ni encima de la lista de contactos ni debajo del titulo

        //Button is above rv list and under title
        onView(withId(R.id.button)).check(PositionAssertions.isAbove(withId(R.id.rv_list)))
        onView(withId(R.id.button)).check(PositionAssertions.isBelow(withId(R.id.textView)))
    }
}