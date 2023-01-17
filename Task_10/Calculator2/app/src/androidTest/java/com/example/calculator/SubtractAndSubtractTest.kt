package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SubtractAndSubtractTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun subtractAndSubtract() {
        val keyEight = Espresso.onView(ViewMatchers.withId(R.id.keyEight))
        val keyNine = Espresso.onView(ViewMatchers.withId(R.id.keyNine))

        val subtract = Espresso.onView(ViewMatchers.withId(R.id.subtract))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyEight.perform(ViewActions.click())

        subtract.perform(ViewActions.click())

        keyNine.perform(ViewActions.click())

        keyNine.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("8-99")))

        subtract.perform(ViewActions.click())

        keyNine.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("8-99-9")))

        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("-100")))
    }
}