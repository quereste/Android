package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class DivideAndAdd {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun divideAndAdd() {
        val keyThree = Espresso.onView(ViewMatchers.withId(R.id.keyThree))
        val keySeven = Espresso.onView(ViewMatchers.withId(R.id.keySeven))

        val add = Espresso.onView(ViewMatchers.withId(R.id.add))
        val divide = Espresso.onView(ViewMatchers.withId(R.id.divide))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))


        keySeven.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("7")))
        divide.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("7/")))
        keyThree.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("7/3")))
        add.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("7/3+")))
        keyThree.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("7/3+3")))
        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("5.333")))
    }
}