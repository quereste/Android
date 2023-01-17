package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class TwoZeros {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun twoZeros() {
        val keyZero = Espresso.onView(ViewMatchers.withId(R.id.keyZero))

        val output = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyZero.perform(ViewActions.click())
        keyZero.perform(ViewActions.click())

        equal.perform(ViewActions.click())

        output.check(ViewAssertions.matches(NumberMatcher.withNumber("0")))
    }
}