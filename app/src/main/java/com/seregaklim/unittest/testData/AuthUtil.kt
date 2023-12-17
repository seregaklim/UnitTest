package com.seregaklim.unittest.testData

object AuthUtil {
    val users = listOf("Петя", "Вася", "Борис")

    fun signUp(
        userName: String,
        password: String,
        repeatPassword: String
    ): Boolean{
        return when {
            userName.isEmpty() || password.isEmpty() -> false
            users.contains(userName) -> false
            password != repeatPassword -> false
            password.length < 2 -> false
            else -> true
        }
    }
}