package com.example.calculator

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Description
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)


object NumberMatcher {
    fun withNumber(number: String?): BoundedMatcher<View?, TextView> {
        checkNotNull(number)
        return object : BoundedMatcher<View?, TextView>(TextView::class.java) {
            public override fun matchesSafely(view: TextView): Boolean {
                return number.toFloat() == view.text.toString().toFloat()
            }

            override fun describeTo(description: Description) {
                description.appendText("with number: ")
            }
        }
    }
}

class CalculatorTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test fun subtractAndSubtract() {
        val keyEight = onView(withId(R.id.keyEight))
        val keyNine = onView(withId(R.id.keyNine))

        val subtract = onView(withId(R.id.subtract))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))

        keyEight.perform(click())
        subtract.perform(click())
        keyNine.perform(click())
        keyNine.perform(click())

        outcome.check(matches(withText("8-99")))

        subtract.perform(click())

        keyNine.perform(click())

        outcome.check(matches(withText("8-99-9")))

        equal.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("-100")))
    }

    @Test fun recoverAfterDivisionByZero() {
        val keyOne = onView(withId(R.id.keyOne))
        val keyZero = onView(withId(R.id.keyZero))

        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))

        val clear = onView(withId(R.id.clear))

        keyOne.perform(click())
        divide.perform(click())
        keyZero.perform(click())

        outcome.check(matches(withText("1/0")))

        equal.perform(click())

        clear.perform(click())
        outcome.check(matches(withText("")))

        equal.perform(click())
    }

    @Test fun performAdditionAfterDivisionByZero() {
        val keyOne = onView(withId(R.id.keyOne))
        val keyZero = onView(withId(R.id.keyZero))

        val add = onView(withId(R.id.add))
        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))

        val clear = onView(withId(R.id.clear))

        keyOne.perform(click())
        divide.perform(click())
        keyZero.perform(click())

        outcome.check(matches(withText("1/0")))

        equal.perform(click())

        clear.perform(click())

        keyOne.perform(click())
        keyOne.perform(click())
        add.perform(click())
        keyOne.perform(click())
        keyZero.perform(click())

        outcome.check(matches(withText("11+10")))

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("21")))
    }

    @Test fun acceptLongNumber() {
        val keyFive = onView(withId(R.id.keyFive))

        val output = onView(withId(R.id.outcome))

        var result : String = ""

        for (i in 1..20) {
            keyFive.perform(click())
            result = result.plus("5")

            output.check(matches(withText(result)))
        }
    }

    @Test fun flipSignLongerNumber() {
        val keyThree = onView(withId(R.id.keyThree))

        val output = onView(withId(R.id.outcome))
        val sign = onView(withId(R.id.switchSign))

        var result : String = "-"

        for (i in 1..20) {
            keyThree.perform(click())
            result = result.plus("3")
        }

        sign.perform(click())

        output.check(matches(NumberMatcher.withNumber(result)))
    }

    @Test fun subtractLongNumber() {
        val keyTwo = onView(withId(R.id.keyTwo))

        val output = onView(withId(R.id.outcome))
        val subtract = onView(withId(R.id.subtract))
        val equal = onView(withId(R.id.equal))


        for (i in 1..20) {
            keyTwo.perform(click())
        }

        subtract.perform(click())

        for (i in 1 .. 20) {
            keyTwo.perform(click())
        }

        equal.perform(click())

        output.check(matches(NumberMatcher.withNumber("0")))
    }

    @Test fun twoZeros() {
        val keyZero = onView(withId(R.id.keyZero))

        val output = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))

        keyZero.perform(click())
        keyZero.perform(click())

        equal.perform(click())

        output.check(matches(NumberMatcher.withNumber("0")))
    }

    @Test fun multipleZeros() {
        val keyZero = onView(withId(R.id.keyZero))

        val output = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        for (i in 1..20) {
            keyZero.perform(click())
        }

        equal.perform(click())

        output.check(matches(NumberMatcher.withNumber("0")))
    }

    @Test fun multipleZerosFlipSign() {
        val keyZero = onView(withId(R.id.keyZero))

        val output = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))
        val sign = onView(withId(R.id.switchSign))


        for (i in 1..20) {
            keyZero.perform(click())
        }

        sign.perform(click())

        equal.perform(click())

        output.check(matches(NumberMatcher.withNumber("0")))
    }

    @Test fun subtractZeros() {
        val keyZero = onView(withId(R.id.keyZero))

        val output = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))
        val subtract = onView(withId(R.id.subtract))

        keyZero.perform(click())

        subtract.perform(click())

        keyZero.perform(click())

        output.check(matches(withText("0-0")))

        equal.perform(click())

        output.check(matches(NumberMatcher.withNumber("0")))
    }

    @Test fun multiplyZeros() {
        val keyZero = onView(withId(R.id.keyZero))

        val output = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))
        val multiply = onView(withId(R.id.multiply))

        keyZero.perform(click())

        multiply.perform(click())

        keyZero.perform(click())

        output.check(matches(withText("0*0")))

        equal.perform(click())

        output.check(matches(NumberMatcher.withNumber("0")))
    }

    @Test fun divideZerosRecover() {
        val keyZero = onView(withId(R.id.keyZero))

        val output = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))
        val clear = onView(withId(R.id.clear))
        val divide = onView(withId(R.id.divide))

        keyZero.perform(click())

        divide.perform(click())

        keyZero.perform(click())

        output.check(matches(withText("0/0")))

        equal.perform(click())

        output.check(matches(NumberMatcher.withNumber("0")))

        clear.perform(click())

        output.check(matches(withText("")))
    }

    @Test fun argumentMismatchRecover() {
        val keyEight = onView(withId(R.id.keyEight))
        val divide = onView(withId(R.id.divide))

        val clear = onView(withId(R.id.clear))
        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))

        keyEight.perform(click())
        divide.perform(click())

        equal.perform(click())

        clear.perform(click())

        outcome.check(matches(withText("")))


    }


    @Test fun visibility() {
        onView(withId(R.id.add)).check(matches(isDisplayed()))
        onView(withId(R.id.clear)).check(matches(isDisplayed()))
        onView(withId(R.id.divide)).check(matches(isDisplayed()))
        onView(withId(R.id.equal)).check(matches(isDisplayed()))
        onView(withId(R.id.keyEight)).check(matches(isDisplayed()))
        onView(withId(R.id.keyFive)).check(matches(isDisplayed()))
        onView(withId(R.id.keyFour)).check(matches(isDisplayed()))
        onView(withId(R.id.keyOne)).check(matches(isDisplayed()))
        onView(withId(R.id.keyNine)).check(matches(isDisplayed()))
        onView(withId(R.id.keySeven)).check(matches(isDisplayed()))
        onView(withId(R.id.keySix)).check(matches(isDisplayed()))
        onView(withId(R.id.keyThree)).check(matches(isDisplayed()))
        onView(withId(R.id.keyTwo)).check(matches(isDisplayed()))
        onView(withId(R.id.keyZero)).check(matches(isDisplayed()))
        onView(withId(R.id.logarithm)).check(matches(isDisplayed()))
        onView(withId(R.id.multiply)).check(matches(isDisplayed()))
        onView(withId(R.id.outcome)).check(matches(isDisplayed()))
        onView(withId(R.id.percent)).check(matches(isDisplayed()))
        onView(withId(R.id.subtract)).check(matches(isDisplayed()))
        onView(withId(R.id.switchSign)).check(matches(isDisplayed()))
    }

    @Test fun initialDisplay() {
        val outcome = onView(withId(R.id.outcome))

        outcome.check(matches(isDisplayed()))
        outcome.check(matches(withText("")))
    }

    @Test fun putDigitEight() {
        val keyEight = onView(withId(R.id.keyEight))

        keyEight.perform(click())

        val outcome = onView(withId(R.id.outcome))

        outcome.check(matches(withText("8")))
    }

    @Test fun putNumber21() {
        val keyTwo = onView(withId(R.id.keyTwo))
        val keyOne = onView(withId(R.id.keyOne))
        val outcome = onView(withId(R.id.outcome))

        outcome.check(matches(withText("")))

        keyTwo.perform(click())

        outcome.check(matches(withText("2")))

        keyOne.perform(click())

        outcome.check(matches(withText("21")))

    }

    @Test fun putLongerNumber237489123() {
        val keyTwo = onView(withId(R.id.keyTwo))
        val keyOne = onView(withId(R.id.keyOne))
        val keySeven = onView(withId(R.id.keySeven))
        val keyFour = onView(withId(R.id.keyFour))
        val keyEight = onView(withId(R.id.keyEight))
        val keyNine = onView(withId(R.id.keyNine))
        val keyThree = onView(withId(R.id.keyThree))

        val outcome = onView(withId(R.id.outcome))

        outcome.check(matches(withText("")))

        keyTwo.perform(click())

        outcome.check(matches(withText("2")))

        keyThree.perform(click())

        outcome.check(matches(withText("23")))

        keySeven.perform(click())

        outcome.check(matches(withText("237")))

        keyFour.perform(click())

        outcome.check(matches(withText("2374")))
        keyEight.perform(click())

        outcome.check(matches(withText("23748")))

        keyNine.perform(click())

        outcome.check(matches(withText("237489")))

        keyOne.perform(click())

        outcome.check(matches(withText("2374891")))

        keyTwo.perform(click())

        outcome.check(matches(withText("23748912")))

        keyThree.perform(click())

        outcome.check(matches(withText("237489123")))
    }

    @Test fun deleteSimple() {
        val outcome = onView(withId(R.id.outcome))
        val keyFive = onView(withId(R.id.keyFive))
        val keyDelete = onView(withId(R.id.clear))

        outcome.check(matches(withText("")))

        keyFive.perform(click())

        outcome.check(matches(withText("5")))

        keyDelete.perform(click())

        outcome.check(matches(withText("")))
    }

    @Test fun deleteAndRewrite () {
        val outcome = onView(withId(R.id.outcome))
        val keyNine = onView(withId(R.id.keyNine))
        val keySeven = onView(withId(R.id.keySeven))

        val keyDelete = onView(withId(R.id.clear))

        outcome.check(matches(withText("")))

        keyNine.perform(click())
        keySeven.perform(click())

        outcome.check(matches(withText("97")))

        keyDelete.perform(click())

        outcome.check(matches(withText("")))

        keyNine.perform(click())
        keySeven.perform(click())

        outcome.check(matches(withText("97")))

    }

    @Test fun deleteMultipleTimes() {
        val outcome = onView(withId(R.id.outcome))
        val keyTwo = onView(withId(R.id.keyTwo))
        val keyDelete = onView(withId(R.id.clear))

        outcome.check(matches(withText("")))

        keyTwo.perform(click())

        outcome.check(matches(withText("2")))

        keyDelete.perform(click())

        outcome.check(matches(withText("")))

        keyDelete.perform(click())
        keyDelete.perform(click())

        outcome.check(matches(withText("")))

        keyDelete.perform(click())
        keyDelete.perform(click())
        keyDelete.perform(click())

        outcome.check(matches(withText("")))
    }

    @Test fun addSimple() {
        val keyFour = onView(withId(R.id.keyFour))
        val keySeven = onView(withId(R.id.keySeven))
        val keyAdd = onView(withId(R.id.add))

        val outcome = onView(withId(R.id.outcome))

        val keyEnter = onView(withId(R.id.equal))

        keyFour.perform(click())
        keyAdd.perform(click())
        keySeven.perform(click())

        outcome.check(matches(withText("4+7")))

        keyEnter.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("11")))
    }

    @Test fun subtractSimple() {
        val keyEight = onView(withId(R.id.keyEight))
        val keyFour = onView(withId(R.id.keyFour))
        val keySubtract = onView(withId(R.id.subtract))

        val outcome = onView(withId(R.id.outcome))

        val keyEnter = onView(withId(R.id.equal))

        keyEight.perform(click())
        keySubtract.perform(click())
        keyFour.perform(click())

        outcome.check(matches(withText("8-4")))

        keyEnter.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("4")))
    }

    @Test fun multiplySimple() {
        val keyTwo = onView(withId(R.id.keyTwo))
        val keyNine = onView(withId(R.id.keyNine))
        val keyMultiply = onView(withId(R.id.multiply))

        val outcome = onView(withId(R.id.outcome))

        val keyEnter = onView(withId(R.id.equal))

        keyTwo.perform(click())
        keyMultiply.perform(click())
        keyNine.perform(click())

        outcome.check(matches(withText("2*9")))

        keyEnter.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("18")))
    }

    @Test fun divideSimple() {
        val keyOne = onView(withId(R.id.keyOne))
        val keyTwo = onView(withId(R.id.keyTwo))
        val keyDivide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))

        val keyEnter = onView(withId(R.id.equal))

        keyOne.perform(click())
        keyDivide.perform(click())
        keyTwo.perform(click())

        outcome.check(matches(withText("1/2")))

        keyEnter.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("0.5")))
    }

    @Test fun powerSimple() {
        val keyOne = onView(withId(R.id.keyOne))
        val keyZero = onView(withId(R.id.keyZero))
        val keySix = onView(withId(R.id.keySix))
        val keyPower = onView(withId(R.id.power))

        val outcome = onView(withId(R.id.outcome))

        val keyEnter = onView(withId(R.id.equal))

        keyOne.perform(click())
        keyZero.perform(click())
        keyPower.perform(click())
        keySix.perform(click())

        outcome.check(matches(withText("10^6")))

        keyEnter.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("1000000")))
    }

    @Test fun flipSign() {
        val keySeven = onView(withId(R.id.keySeven))
        val keyTwo = onView(withId(R.id.keyTwo))
        val sign = onView(withId(R.id.switchSign))

        val outcome = onView(withId(R.id.outcome))


        keySeven.perform(click())
        keyTwo.perform(click())

        outcome.check(matches(withText("72")))

        sign.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("-72")))
    }

    @Test fun flipSignTwice() {
        val keyFour = onView(withId(R.id.keyFour))
        val keyOne = onView(withId(R.id.keyOne))
        val sign = onView(withId(R.id.switchSign))

        val outcome = onView(withId(R.id.outcome))


        keyFour.perform(click())
        keyOne.perform(click())

        sign.perform(click())
        sign.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("41")))
    }

    @Test fun flipSignManyEven() {
        val keyTwo = onView(withId(R.id.keyTwo))

        val sign = onView(withId(R.id.switchSign))

        val outcome = onView(withId(R.id.outcome))


        keyTwo.perform(click())
        keyTwo.perform(click())

        for (i in 1 .. 10) {
            sign.perform(click())
            sign.perform(click())
        }

        outcome.check(matches(NumberMatcher.withNumber("22")))
    }

    @Test fun flipSignManyOdd() {
        val keyTwo = onView(withId(R.id.keyTwo))

        val sign = onView(withId(R.id.switchSign))

        val outcome = onView(withId(R.id.outcome))


        keyTwo.perform(click())
        keyTwo.perform(click())

        for (i in 1 .. 12) {
            sign.perform(click())
            sign.perform(click())
        }

        sign.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("-22")))
    }

    @Test fun flipSignInPositiveOutcome() {
        val keyOne = onView(withId(R.id.keyOne))
        val keyZero = onView(withId(R.id.keyZero))

        val keySeven = onView(withId(R.id.keySeven))

        val outcome = onView(withId(R.id.outcome))
        val equals = onView(withId(R.id.equal))
        val multiply = onView(withId(R.id.multiply))
        val sign = onView(withId(R.id.switchSign))

        keyOne.perform(click())
        keyZero.perform(click())

        multiply.perform(click())

        keySeven.perform(click())

        outcome.check(matches(withText("10*7")))

        equals.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("70")))

        sign.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("-70")))
    }

    @Test fun flipSignInNegativeOutcome() {
        val keyFive = onView(withId(R.id.keyFive))

        val keySeven = onView(withId(R.id.keySeven))

        val outcome = onView(withId(R.id.keySeven))
        val equals = onView(withId(R.id.equal))
        val subtract = onView(withId(R.id.subtract))
        val sign = onView(withId(R.id.switchSign))

        keyFive.perform(click())

        subtract.perform(click())

        keySeven.perform(click())

        outcome.check(matches(withText("5-7")))

        equals.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("-2")))

        sign.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("2")))
    }

    @Test fun appendDigitToOutcome() {
        val keyOne = onView(withId(R.id.keyOne))
        val keyThree = onView(withId(R.id.keyThree))

        val equal = onView(withId(R.id.equal))
        val outcome = onView(withId(R.id.outcome))
        val divide = onView(withId(R.id.divide))

        keyOne.perform(click())
        divide.perform(click())
        keyThree.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("0.333")))

        keyThree.perform(click())
        keyThree.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("0.33333")))

    }

    @Test fun negativePower() {
        val keyOne = onView(withId(R.id.keyOne))
        val keyZero = onView(withId(R.id.keyZero))

        val minus = onView(withId(R.id.subtract))

        val power = onView(withId(R.id.power))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keyOne.perform(click())
        keyZero.perform(click())

        power.perform(click())

        minus.perform(click())

        keyOne.perform(click())
        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("0.1")))
    }

    @Test fun twoOperatorsAddMultiply() {
        val keyOne = onView(withId(R.id.keyOne))
        val keyThree = onView(withId(R.id.keyThree))

        val add = onView(withId(R.id.add))
        val multiply = onView(withId(R.id.multiply))

        val outcome = onView(withId(R.id.outcome))

        keyOne.perform(click())
        keyThree.perform(click())

        add.perform(click())

        keyThree.perform(click())
        keyThree.perform(click())

        multiply.perform(click())
        keyThree.perform(click())

        outcome.check(matches(withText("13+33*3")))
    }

    @Test fun twoOperatorsSubtractAndDivide() {
        val keyFour = onView(withId(R.id.keyFour))
        val keyNine = onView(withId(R.id.keyNine))

        val subtract = onView(withId(R.id.subtract))
        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))

        keyFour.perform(click())

        subtract.perform(click())

        keyNine.perform(click())

        divide.perform(click())
        keyFour.perform(click())

        outcome.check(matches(withText("4-9/4")))
    }

    @Test fun addAndMultiply() {
        val keyFive = onView(withId(R.id.keyFive))
        val keyTwo = onView(withId(R.id.keyTwo))

        val add = onView(withId(R.id.add))
        val multiply = onView(withId(R.id.multiply))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keyFive.perform(click())
        keyTwo.perform(click())

        add.perform(click())

        keyTwo.perform(click())

        multiply.perform(click())
        keyTwo.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("56")))
    }

    @Test fun addAndSubtract() {
        val keyEight = onView(withId(R.id.keyEight))
        val keyFour = onView(withId(R.id.keyFour))

        val add = onView(withId(R.id.add))
        val subtract = onView(withId(R.id.subtract))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keyEight.perform(click())

        add.perform(click())

        keyEight.perform(click())

        subtract.perform(click())
        keyFour.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("12")))
    }

    @Test fun subtractAndAdd() {
        val keyEight = onView(withId(R.id.keyEight))
        val keyFour = onView(withId(R.id.keyFour))

        val add = onView(withId(R.id.add))
        val subtract = onView(withId(R.id.subtract))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keyEight.perform(click())

        subtract.perform(click())

        keyEight.perform(click())

        add.perform(click())
        keyFour.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("4")))
    }

    @Test fun multiplyAndAdd() {
        val keyFive = onView(withId(R.id.keyFive))
        val keyTwo = onView(withId(R.id.keyTwo))

        val add = onView(withId(R.id.add))
        val multiply = onView(withId(R.id.multiply))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keyFive.perform(click())
        keyTwo.perform(click())

        multiply.perform(click())

        keyTwo.perform(click())

        add.perform(click())
        keyTwo.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("106")))
    }

    @Test fun addAndDivide() {
        val keyThree = onView(withId(R.id.keyThree))
        val keySeven = onView(withId(R.id.keySeven))

        val add = onView(withId(R.id.add))
        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keySeven.perform(click())

        add.perform(click())

        keyThree.perform(click())

        divide.perform(click())
        keyThree.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("8")))
    }

    @Test fun divideAndAdd() {
        val keyThree = onView(withId(R.id.keyThree))
        val keySeven = onView(withId(R.id.keySeven))

        val add = onView(withId(R.id.add))
        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keySeven.perform(click())

        divide.perform(click())

        keyThree.perform(click())

        add.perform(click())
        keyThree.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("5.333")))
    }

    @Test fun divideAndSubtract() {
        val keyFour = onView(withId(R.id.keyFour))
        val keyTwo = onView(withId(R.id.keyTwo))

        val subtract = onView(withId(R.id.add))
        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keyFour.perform(click())

        divide.perform(click())

        keyFour.perform(click())

        subtract.perform(click())
        keyTwo.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("-1")))
    }

    @Test fun subtractAndDivide() {
        val keyFour = onView(withId(R.id.keyFour))
        val keyTwo = onView(withId(R.id.keyTwo))

        val subtract = onView(withId(R.id.add))
        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keyFour.perform(click())

        subtract.perform(click())

        keyFour.perform(click())

        divide.perform(click())
        keyTwo.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("2")))
    }

    @Test fun divideAndMultiply() {
        val keySix = onView(withId(R.id.keySix))
        val keyThree = onView(withId(R.id.keySix))

        val multiply = onView(withId(R.id.add))
        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keySix.perform(click())

        divide.perform(click())

        keySix.perform(click())

        multiply.perform(click())
        keyThree.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("3")))
    }

    @Test fun multiplyAndDivide() {
        val keySix = onView(withId(R.id.keySix))
        val keyThree = onView(withId(R.id.keySix))

        val multiply = onView(withId(R.id.add))
        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))


        keySix.perform(click())

        multiply.perform(click())

        keySix.perform(click())

        divide.perform(click())
        keyThree.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("12")))
    }

    @Test fun multiplyAndMultiply() {
        val keyFour = onView(withId(R.id.keyFour))
        val keyNine = onView(withId(R.id.keyNine))

        val multiply = onView(withId(R.id.multiply))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))

        keyFour.perform(click())
        multiply.perform(click())
        keyNine.perform(click())
        multiply.perform(click())
        keyFour.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("144")))
    }

    @Test fun addAndAdd() {
        val keyFive = onView(withId(R.id.keyFive))
        val keyTwo = onView(withId(R.id.keyTwo))

        val add = onView(withId(R.id.add))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))

        keyTwo.perform(click())
        add.perform(click())
        keyTwo.perform(click())
        add.perform(click())
        keyFive.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("9")))
    }

    @Test fun divideAndDivide() {
        val keyOne = onView(withId(R.id.keyOne))
        val keyZero = onView(withId(R.id.keyZero))

        val divide = onView(withId(R.id.divide))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))

        keyOne.perform(click())
        keyZero.perform(click())
        keyZero.perform(click())
        keyZero.perform(click())

        divide.perform(click())

        keyOne.perform(click())
        keyZero.perform(click())

        outcome.check(matches(withText("1000/10")))

        divide.perform(click())

        keyOne.perform(click())
        keyZero.perform(click())

        outcome.check(matches(withText("1000/10/10")))

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("10")))
    }

    @Test fun powerAndPower() {
        val keyTwo = onView(withId(R.id.keyTwo))

        val power = onView(withId(R.id.power))

        val outcome = onView(withId(R.id.outcome))
        val equal = onView(withId(R.id.equal))

        keyTwo.perform(click())
        power.perform(click())
        keyTwo.perform(click())
        power.perform(click())
        keyTwo.perform(click())

        equal.perform(click())

        outcome.check(matches(NumberMatcher.withNumber("16")))
    }


}
