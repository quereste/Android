package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MultipleZerosWithFlipSign {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun multipleZerosFlipSign() {
        val keyZero = Espresso.onView(ViewMatchers.withId(R.id.keyZero))

        val output = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))
        val sign = Espresso.onView(ViewMatchers.withId(R.id.switchSign))


        for (i in 1..20) {
            keyZero.perform(ViewActions.click())
        }

        sign.perform(ViewActions.click())

        equal.perform(ViewActions.click())

        output.check(ViewAssertions.matches(NumberMatcher.withNumber("0")))
    }
}