package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class FlipSignManyEven {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun flipSignManyEven() {
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))

        val sign = Espresso.onView(ViewMatchers.withId(R.id.switchSign))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))


        keyTwo.perform(ViewActions.click())
        keyTwo.perform(ViewActions.click())

        for (i in 1 .. 10) {
            sign.perform(ViewActions.click())
            sign.perform(ViewActions.click())
        }

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("22")))
    }
}