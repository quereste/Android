package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class FlipSignInNegativeOutcome {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun flipSignInNegativeOutcome() {
        val keyFive = Espresso.onView(ViewMatchers.withId(R.id.keyFive))

        val keySeven = Espresso.onView(ViewMatchers.withId(R.id.keySeven))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equals = Espresso.onView(ViewMatchers.withId(R.id.equal))
        val subtract = Espresso.onView(ViewMatchers.withId(R.id.subtract))
        val sign = Espresso.onView(ViewMatchers.withId(R.id.switchSign))

        keyFive.perform(ViewActions.click())
        Thread.sleep(100)
        subtract.perform(ViewActions.click())
        Thread.sleep(100)
        keySeven.perform(ViewActions.click())
        Thread.sleep(100)
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("5-7")))

        equals.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("-2")))

        sign.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("2")))
    }
}