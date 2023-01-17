package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class AddSimple {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addSimple() {
        val keyFour = Espresso.onView(ViewMatchers.withId(R.id.keyFour))
        val keySeven = Espresso.onView(ViewMatchers.withId(R.id.keySeven))
        val keyAdd = Espresso.onView(ViewMatchers.withId(R.id.add))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        val keyEnter = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyFour.perform(ViewActions.click())
        Thread.sleep(100)
        keyAdd.perform(ViewActions.click())
        Thread.sleep(100)
        keySeven.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("4+7")))

        keyEnter.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("11")))
    }

}