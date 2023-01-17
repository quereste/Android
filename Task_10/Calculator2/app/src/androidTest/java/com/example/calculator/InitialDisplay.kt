package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class InitialDisplay {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun initialDisplay() {
        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        outcome.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))
    }
}