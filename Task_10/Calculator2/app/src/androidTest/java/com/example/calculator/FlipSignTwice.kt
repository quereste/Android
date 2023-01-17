package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class FlipSignTwice {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun flipSignTwice() {
        val keyFour = Espresso.onView(ViewMatchers.withId(R.id.keyFour))
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val sign = Espresso.onView(ViewMatchers.withId(R.id.switchSign))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))


        keyFour.perform(ViewActions.click())
        keyOne.perform(ViewActions.click())

        sign.perform(ViewActions.click())
        sign.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("41")))
    }
}