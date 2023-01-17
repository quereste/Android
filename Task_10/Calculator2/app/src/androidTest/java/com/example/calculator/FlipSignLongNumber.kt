package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class FlipSignLongNumber {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun flipSignLongerNumber() {
        val keyThree = Espresso.onView(ViewMatchers.withId(R.id.keyThree))

        val output = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val sign = Espresso.onView(ViewMatchers.withId(R.id.switchSign))

        var result : String = "-"

        for (i in 1..20) {
            keyThree.perform(ViewActions.click())
            result = result.plus("3")
        }

        sign.perform(ViewActions.click())

        output.check(ViewAssertions.matches(NumberMatcher.withNumber(result)))
    }

}