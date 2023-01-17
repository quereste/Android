package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MultiplySimple {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun multiplySimple() {
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))
        val keyNine = Espresso.onView(ViewMatchers.withId(R.id.keyNine))
        val keyMultiply = Espresso.onView(ViewMatchers.withId(R.id.multiply))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        val keyEnter = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyTwo.perform(ViewActions.click())
        Thread.sleep(100)
        keyMultiply.perform(ViewActions.click())
        Thread.sleep(100)
        keyNine.perform(ViewActions.click())
        Thread.sleep(100)
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2*9")))

        keyEnter.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("18")))
    }
}