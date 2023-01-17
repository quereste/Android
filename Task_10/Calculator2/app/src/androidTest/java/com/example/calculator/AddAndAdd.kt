package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class AddAndAdd {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addAndAdd() {
        val keyFive = Espresso.onView(ViewMatchers.withId(R.id.keyFive))
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))

        val add = Espresso.onView(ViewMatchers.withId(R.id.add))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))

        keyTwo.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2")))
        add.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2+")))
        keyTwo.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2+2")))
        add.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2+2+")))
        keyFive.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2+2+5")))
        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("9")))
    }

}