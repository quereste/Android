package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SubtractAndDivide {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun subtractAndDivide() {
        val keyFour = Espresso.onView(ViewMatchers.withId(R.id.keyFour))
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))

        val subtract = Espresso.onView(ViewMatchers.withId(R.id.subtract))
        val divide = Espresso.onView(ViewMatchers.withId(R.id.divide))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))


        keyFour.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4")))
        subtract.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4-")))
        keyFour.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4-4")))
        divide.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4-4/")))
        keyTwo.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4-4/2")))
        equal.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("2")))
    }
}