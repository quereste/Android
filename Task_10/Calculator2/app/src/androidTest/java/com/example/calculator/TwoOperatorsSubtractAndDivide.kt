package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class TwoOperatorsSubtractAndDivide {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun twoOperatorsSubtractAndDivide() {
        val keyFour = Espresso.onView(ViewMatchers.withId(R.id.keyFour))
        val keyNine = Espresso.onView(ViewMatchers.withId(R.id.keyNine))

        val subtract = Espresso.onView(ViewMatchers.withId(R.id.subtract))
        val divide = Espresso.onView(ViewMatchers.withId(R.id.divide))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        keyFour.perform(ViewActions.click())

        subtract.perform(ViewActions.click())

        keyNine.perform(ViewActions.click())

        divide.perform(ViewActions.click())
        keyFour.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4-9/4")))
    }
}