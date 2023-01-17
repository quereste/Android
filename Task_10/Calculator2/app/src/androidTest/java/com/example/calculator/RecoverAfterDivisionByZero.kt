package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class RecoverAfterDivisionByZero {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun recoverAfterDivisionByZero() {
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val keyZero = Espresso.onView(ViewMatchers.withId(R.id.keyZero))

        val divide = Espresso.onView(ViewMatchers.withId(R.id.divide))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))

        val clear = Espresso.onView(ViewMatchers.withId(R.id.clear))

        keyOne.perform(ViewActions.click())

        divide.perform(ViewActions.click())

        keyZero.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1/0")))

        equal.perform(ViewActions.click())

        clear.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))

        equal.perform(ViewActions.click())
    }
}