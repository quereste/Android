package com.example.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class PutLongerNumber {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun putLongerNumber237489123() {
        val keyTwo = Espresso.onView(ViewMatchers.withId(R.id.keyTwo))
        val keyOne = Espresso.onView(ViewMatchers.withId(R.id.keyOne))
        val keySeven = Espresso.onView(ViewMatchers.withId(R.id.keySeven))
        val keyFour = Espresso.onView(ViewMatchers.withId(R.id.keyFour))
        val keyEight = Espresso.onView(ViewMatchers.withId(R.id.keyEight))
        val keyNine = Espresso.onView(ViewMatchers.withId(R.id.keyNine))
        val keyThree = Espresso.onView(ViewMatchers.withId(R.id.keyThree))

        val outcome = Espresso.onView(ViewMatchers.withId(R.id.outcome))

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("")))

        keyTwo.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2")))

        keyThree.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("23")))

        keySeven.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("237")))

        keyFour.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2374")))
        keyEight.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("23748")))

        keyNine.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("237489")))

        keyOne.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("2374891")))

        keyTwo.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("23748912")))

        keyThree.perform(ViewActions.click())

        outcome.check(ViewAssertions.matches(ViewMatchers.withText("237489123")))
    }
}