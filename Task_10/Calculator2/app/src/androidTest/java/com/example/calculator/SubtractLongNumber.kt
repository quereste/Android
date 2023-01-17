package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SubtractLongNumber {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun subtractLongNumber() {
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))

        val output = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val subtract = Espresso.onView(ViewMatchers.withId(R.id.subtract))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))


        for (i in 1..20) {
            keyTwo.perform(ViewActions.click())
        }

        subtract.perform(ViewActions.click())

        for (i in 1 .. 20) {
            keyTwo.perform(ViewActions.click())
        }

        equal.perform(ViewActions.click())

        output.check(ViewAssertions.matches(NumberMatcher.withNumber("0")))
    }
}