package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class AppendDigitToOutcome {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun appendDigitToOutcome() {
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val keyThree = Espresso.onView(ViewMatchers.withId(R.id.keyThree))

        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))
        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val divide = Espresso.onView(ViewMatchers.withId(R.id.divide))

        keyOne.perform(ViewActions.click())
        divide.perform(ViewActions.click())
        keyThree.perform(ViewActions.click())

        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("0.333")))

        keyThree.perform(ViewActions.click())
        keyThree.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("0.33333")))

    }
}