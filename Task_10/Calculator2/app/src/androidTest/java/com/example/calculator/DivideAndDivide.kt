package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class DivideAndDivide {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun divideAndDivide() {
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val keyZero = Espresso.onView(ViewMatchers.withId(R.id.keyZero))

        val divide = Espresso.onView(ViewMatchers.withId(R.id.divide))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyOne.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1")))
        keyZero.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("10")))
        keyZero.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("100")))
        keyZero.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1000")))
        divide.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1000/")))
        keyOne.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1000/1")))
        keyZero.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1000/10")))
        divide.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1000/10/")))
        keyOne.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1000/10/1")))
        keyZero.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("1000/10/10")))
        equal.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("10")))
    }
}