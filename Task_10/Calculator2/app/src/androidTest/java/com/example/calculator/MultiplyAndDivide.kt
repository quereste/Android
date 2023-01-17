package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MultiplyAndDivide {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun multiplyAndDivide() {
        val keySix = Espresso.onView(ViewMatchers.withId(R.id.keySix))
        val keyThree = Espresso.onView(ViewMatchers.withId(R.id.keyThree))

        val multiply = Espresso.onView(ViewMatchers.withId(R.id.multiply))
        val divide = Espresso.onView(ViewMatchers.withId(R.id.divide))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))
        val equal = Espresso.onView(ViewMatchers.withId(R.id.equal))


        keySix.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("6")))
        multiply.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("6*")))

        keySix.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("6*6")))
        divide.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("6*6/")))
        keyThree.perform(ViewActions.click())
        outcome.check(ViewAssertions.matches(ViewMatchers.withText("6*6/3")))
        equal.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(NumberMatcher.withNumber("12")))
    }

}