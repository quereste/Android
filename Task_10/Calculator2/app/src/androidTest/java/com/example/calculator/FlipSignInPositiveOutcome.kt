package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class FlipSignInPositiveOutcome {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun flipSignInPositiveOutcome() {
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val keyZero = Espresso.onView(ViewMatchers.withId(R.id.keyZero))

        val keySeven = Espresso.onView(ViewMatchers.withId(R.id.keySeven))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equals = Espresso.onView(ViewMatchers.withId(R.id.equal))
        val multiply = Espresso.onView(ViewMatchers.withId(R.id.multiply))
        val sign = Espresso.onView(ViewMatchers.withId(R.id.switchSign))

        keyOne.perform(ViewActions.click())
        keyZero.perform(ViewActions.click())

        multiply.perform(ViewActions.click())

        keySeven.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("10*7")))

        equals.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("70")))

        sign.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("-70")))
    }
}