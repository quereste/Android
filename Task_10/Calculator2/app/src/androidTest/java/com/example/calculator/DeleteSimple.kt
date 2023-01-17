package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class DeleteSimple {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deleteSimple() {
        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val keyFive = Espresso.onView(ViewMatchers.withId(R.id.keyFive))
        val keyDelete = Espresso.onView(ViewMatchers.withId(R.id.clear))

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))

        keyFive.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("5")))

        keyDelete.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))
    }
}