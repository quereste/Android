package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class AcceptLongNumber {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun acceptLongNumber() {
        val keyFive = Espresso.onView(ViewMatchers.withId(R.id.keyFive))

        val output = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        var result : String = ""

        for (i in 1..20) {
            keyFive.perform(ViewActions.click())
            result = result.plus("5")

            output.check(ViewAssertions.matches(ViewMatchers.withText(result)))
        }
    }
}