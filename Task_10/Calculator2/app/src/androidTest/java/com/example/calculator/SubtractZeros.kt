package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SubtractZeros {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun subtractZeros() {
        val keyZero = Espresso.onView(ViewMatchers.withId(R.id.keyZero))

        val output = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))
        val subtract = Espresso.onView(ViewMatchers.withId(R.id.subtract))

        keyZero.perform(ViewActions.click())

        subtract.perform(ViewActions.click())

        keyZero.perform(ViewActions.click())

        output.check(ViewAssertions.matches(ViewMatchers.withText("0-0")))

        equal.perform(ViewActions.click())

        output.check(ViewAssertions.matches(NumberMatcher.withNumber("0")))
    }

}