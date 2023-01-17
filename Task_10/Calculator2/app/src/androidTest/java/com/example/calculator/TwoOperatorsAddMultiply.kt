package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class TwoOperatorsAddMultiply {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun twoOperatorsAddMultiply() {
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val keyThree = Espresso.onView(ViewMatchers.withId(R.id.keyThree))

        val add = Espresso.onView(ViewMatchers.withId(R.id.add))
        val multiply = Espresso.onView(ViewMatchers.withId(R.id.multiply))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        keyOne.perform(ViewActions.click())
        keyThree.perform(ViewActions.click())

        add.perform(ViewActions.click())

        keyThree.perform(ViewActions.click())
        keyThree.perform(ViewActions.click())

        multiply.perform(ViewActions.click())
        keyThree.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("13+33*3")))
    }
}