package com.example.calculator

import android.view.View
import android.widget.TextView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

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