package com.example.uiappfinal

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(Test1::class, Test2::class, Test2b::class, Test3::class)
    class Test0 {

        @get:Rule
        val activityRule = ActivityScenarioRule(MainActivity::class.java)

    }
