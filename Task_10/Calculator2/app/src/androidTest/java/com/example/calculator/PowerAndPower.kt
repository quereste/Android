package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class PowerAndPower {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun powerAndPower() {
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))

        val power = Espresso.onView(ViewMatchers.withId(R.id.power))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyTwo.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2")))
        power.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2^")))
        keyTwo.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2^2")))
        power.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2^2^")))
        keyTwo.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2^2^2")))
        equal.perform(ViewActions.click())


        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("16")))
    }
}