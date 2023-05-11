package com.example.uiappfinal

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.PositionAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class Test2b {

    @get:Rule
    val activityRule = ActivityScenarioRule(Form::class.java)

    @Test
    fun posicionsFormActivity(){
        //Title
        onView(ViewMatchers.withId(R.id.nombre)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formName)))
        onView(ViewMatchers.withId(R.id.nombre)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formSurname)))
        onView(ViewMatchers.withId(R.id.nombre)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formPhone)))
        onView(ViewMatchers.withId(R.id.nombre)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formBirthdate)))
        onView(ViewMatchers.withId(R.id.nombre)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formEmail)))
        onView(ViewMatchers.withId(R.id.nombre)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formCreateButton)))

        //Name input
        onView(ViewMatchers.withId(R.id.formName)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.nombre)))
        //onView(ViewMatchers.withId(R.id.formName)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formSurname)))
        onView(ViewMatchers.withId(R.id.formName)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formPhone)))
        onView(ViewMatchers.withId(R.id.formName)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formBirthdate)))
        onView(ViewMatchers.withId(R.id.formName)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formEmail)))
        onView(ViewMatchers.withId(R.id.formName)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formCreateButton)))

        //Surname input
        onView(ViewMatchers.withId(R.id.formSurname)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.nombre)))
        //onView(ViewMatchers.withId(R.id.formSurname)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.formName)))
        onView(ViewMatchers.withId(R.id.formSurname)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formPhone)))
        onView(ViewMatchers.withId(R.id.formSurname)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formBirthdate)))
        onView(ViewMatchers.withId(R.id.formSurname)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formEmail)))
        onView(ViewMatchers.withId(R.id.formSurname)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formCreateButton)))

        //Phone input
        onView(ViewMatchers.withId(R.id.formPhone)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.formName)))
        onView(ViewMatchers.withId(R.id.formPhone)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.formSurname)))
        onView(ViewMatchers.withId(R.id.formPhone)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.nombre)))
        onView(ViewMatchers.withId(R.id.formPhone)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formBirthdate)))
        onView(ViewMatchers.withId(R.id.formPhone)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formEmail)))
        onView(ViewMatchers.withId(R.id.formPhone)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formCreateButton)))

        //BirthDate input
        onView(ViewMatchers.withId(R.id.formBirthdate)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.formName)))
        onView(ViewMatchers.withId(R.id.formBirthdate)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.formSurname)))
        onView(ViewMatchers.withId(R.id.formBirthdate)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.nombre)))
        onView(ViewMatchers.withId(R.id.formBirthdate)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.nombre)))
        onView(ViewMatchers.withId(R.id.formBirthdate)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formEmail)))
        onView(ViewMatchers.withId(R.id.formBirthdate)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formCreateButton)))

        //Email input
        onView(ViewMatchers.withId(R.id.formEmail)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.formName)))
        onView(ViewMatchers.withId(R.id.formEmail)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.formSurname)))
        onView(ViewMatchers.withId(R.id.formEmail)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.nombre)))
        onView(ViewMatchers.withId(R.id.formEmail)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.nombre)))
        onView(ViewMatchers.withId(R.id.formEmail)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.nombre)))
        onView(ViewMatchers.withId(R.id.formEmail)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.formCreateButton)))
    }
}