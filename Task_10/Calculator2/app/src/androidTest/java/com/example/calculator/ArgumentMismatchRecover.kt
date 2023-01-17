package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class ArgumentMismatchRecover {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun argumentMismatchRecover() {
        val keyEight = Espresso.onView(ViewMatchers.withId(R.id.keyEight))
        val divide = Espresso.onView(ViewMatchers.withId(R.id.divide))

        val clear = Espresso.onView(ViewMatchers.withId(R.id.clear))
        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyEight.perform(ViewActions.click())
        divide.perform(ViewActions.click())

        equal.perform(ViewActions.click())

        clear.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))


    }
}