package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class PowerSimple {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun powerSimple() {
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val keyZero = Espresso.onView(ViewMatchers.withId(R.id.keyZero))
        val keySix = Espresso.onView(ViewMatchers.withId(R.id.keySix))
        val keyPower = Espresso.onView(ViewMatchers.withId(R.id.power))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        val keyEnter = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyOne.perform(ViewActions.click())
        keyZero.perform(ViewActions.click())
        keyPower.perform(ViewActions.click())

        keySix.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("10^6")))

        keyEnter.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("1000000")))
    }
}