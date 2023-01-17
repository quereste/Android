package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class AddAndSubtract {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun addAndSubtract() {
        val keyEight = Espresso.onView(ViewMatchers.withId(R.id.keyEight))
        val keyFour = Espresso.onView(ViewMatchers.withId(R.id.keyFour))

        val add = Espresso.onView(ViewMatchers.withId(R.id.add))
        val subtract = Espresso.onView(ViewMatchers.withId(R.id.subtract))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))


        keyEight.perform(ViewActions.click())
        Thread.sleep(100)
        add.perform(ViewActions.click())
        Thread.sleep(100)
        keyEight.perform(ViewActions.click())
        Thread.sleep(100)
        subtract.perform(ViewActions.click())
        Thread.sleep(100)
        keyFour.perform(ViewActions.click())
        Thread.sleep(100)
        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("12")))
    }
}