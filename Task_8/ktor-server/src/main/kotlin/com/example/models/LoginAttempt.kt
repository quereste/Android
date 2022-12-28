package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginAttempt(val username: String, val password: String)
