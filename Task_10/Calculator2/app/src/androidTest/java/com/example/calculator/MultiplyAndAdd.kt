package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MultiplyAndAdd {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun multiplyAndAdd() {
        val keyFive = Espresso.onView(ViewMatchers.withId(R.id.keyFive))
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))

        val add = Espresso.onView(ViewMatchers.withId(R.id.add))
        val multiply = Espresso.onView(ViewMatchers.withId(R.id.multiply))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))


        keyFive.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("5")))
        keyTwo.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("52")))
        multiply.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("52*")))
        keyTwo.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("52*2")))
        add.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("52*2+")))
        keyTwo.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("52*2+2")))

        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("106")))
    }
}