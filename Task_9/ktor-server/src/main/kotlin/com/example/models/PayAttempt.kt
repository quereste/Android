package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class PayAttempt(val card_number: String, val CVC: String, val date: String)

val customerMemory = mutableListOf<PayAttempt>(
    PayAttempt("000000000000000000000000", "000", "01/2111")
)