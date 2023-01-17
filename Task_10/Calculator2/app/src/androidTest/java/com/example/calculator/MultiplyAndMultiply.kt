package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MultiplyAndMultiply {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun multiplyAndMultiply() {
        val keyFour = Espresso.onView(ViewMatchers.withId(R.id.keyFour))
        val keyNine = Espresso.onView(ViewMatchers.withId(R.id.keyNine))

        val multiply = Espresso.onView(ViewMatchers.withId(R.id.multiply))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyFour.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4")))
        multiply.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4*")))
        keyNine.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4*9")))
        multiply.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4*9*")))
        keyFour.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4*9*4")))

        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("144")))
    }
}