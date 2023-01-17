package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class DivideSimple {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun divideSimple() {
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))
        val keyDivide = Espresso.onView(ViewMatchers.withId(R.id.divide))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        val keyEnter = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyOne.perform(ViewActions.click())
        keyDivide.perform(ViewActions.click())
        keyTwo.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1/2")))

        keyEnter.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("0.5")))
    }
}