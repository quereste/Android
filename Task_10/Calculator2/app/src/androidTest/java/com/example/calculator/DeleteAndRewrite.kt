package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class DeleteAndRewrite {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun deleteAndRewrite () {
        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val keyNine = Espresso.onView(ViewMatchers.withId(R.id.keyNine))
        val keySeven = Espresso.onView(ViewMatchers.withId(R.id.keySeven))

        val keyDelete = Espresso.onView(ViewMatchers.withId(R.id.clear))

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))

        keyNine.perform(ViewActions.click())

        keySeven.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("97")))

        keyDelete.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))

        keyNine.perform(ViewActions.click())

        keySeven.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("97")))

    }
}