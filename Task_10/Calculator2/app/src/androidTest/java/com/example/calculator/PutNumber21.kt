package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class PutNumber21 {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun putNumber21() {
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))

        keyTwo.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2")))

        keyOne.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("21")))

    }

}