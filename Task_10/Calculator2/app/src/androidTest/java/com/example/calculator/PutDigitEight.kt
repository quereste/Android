package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class PutDigitEight {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun putDigitEight() {
        val keyEight = Espresso.onView(ViewMatchers.withId(R.id.keyEight))

        keyEight.perform(ViewActions.click())

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("8")))
    }
}