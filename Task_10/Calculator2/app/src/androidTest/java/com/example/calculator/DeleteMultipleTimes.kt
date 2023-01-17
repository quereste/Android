package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class DeleteMultipleTimes {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deleteMultipleTimes() {
        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))
        val keyDelete = Espresso.onView(ViewMatchers.withId(R.id.clear))

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))

        keyTwo.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2")))

        keyDelete.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))

        keyDelete.perform(ViewActions.click())
        keyDelete.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))

        keyDelete.perform(ViewActions.click())
        keyDelete.perform(ViewActions.click())
        keyDelete.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))
    }
}