package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SubtractSimple {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun subtractSimple() {
        val keyEight = Espresso.onView(ViewMatchers.withId(R.id.keyEight))
        val keyFour = Espresso.onView(ViewMatchers.withId(R.id.keyFour))
        val keySubtract = Espresso.onView(ViewMatchers.withId(R.id.subtract))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        val keyEnter = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyEight.perform(ViewActions.click())
        keySubtract.perform(ViewActions.click())
        keyFour.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("8-4")))

        keyEnter.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("4")))
    }
}