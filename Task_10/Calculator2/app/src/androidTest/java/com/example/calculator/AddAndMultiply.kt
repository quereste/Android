package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class AddAndMultiply {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addAndMultiply() {
        val keyFive = Espresso.onView(ViewMatchers.withId(R.id.keyFive))
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))

        val add = Espresso.onView(ViewMatchers.withId(R.id.add))
        val multiply = Espresso.onView(ViewMatchers.withId(R.id.multiply))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))


        keyFive.perform(ViewActions.click())
        keyTwo.perform(ViewActions.click())

        add.perform(ViewActions.click())

        keyTwo.perform(ViewActions.click())

        multiply.perform(ViewActions.click())
        keyTwo.perform(ViewActions.click())

        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("56")))
    }
}