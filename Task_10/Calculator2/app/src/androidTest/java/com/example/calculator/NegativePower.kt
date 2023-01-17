package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class NegativePower {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun negativePower() {
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val keyZero = Espresso.onView(ViewMatchers.withId(R.id.keyZero))

        val minus = Espresso.onView(ViewMatchers.withId(R.id.subtract))

        val power = Espresso.onView(ViewMatchers.withId(R.id.power))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))


        keyOne.perform(ViewActions.click())
        keyZero.perform(ViewActions.click())

        power.perform(ViewActions.click())

        minus.perform(ViewActions.click())

        keyOne.perform(ViewActions.click())
        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("0.1")))
    }

}