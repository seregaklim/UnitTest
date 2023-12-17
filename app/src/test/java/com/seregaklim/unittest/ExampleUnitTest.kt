package com.seregaklim.unittest

import org.junit.Test

import org.junit.Assert.*

import com.google.common.truth.Truth.*
import com.seregaklim.unittest.testData.AuthUtil

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    class AuthUtilTest {
        @Test
        // возвращает ли функция false, когда пользователь передает пустой username или password.
        fun `signUp function returns false when username or password is empty`() {
            val userName = ""
            val password = ""
            val repeatPassword = ""
            assertThat(AuthUtil.signUp(userName, password, repeatPassword)).isFalse()
        }

        //Второй тест должен проверить, существует ли уже введенный username. Если он существует, функция должна вернуть false.
        @Test
        fun `signUp function returns false when username is taken`() {
            val userName = "Петя"
            val password = "12345"
            val repeatPassword = "12345"
            assertThat(AuthUtil.signUp(userName, password, repeatPassword)).isFalse()
        }

        //Для третьего теста мы собираемся передать разные значения пароля и повторного пароля. Этот тест должен вернуть false.
        @Test
        fun `signUp function returns false when password and repeat password don't match`() {
            val userName = "Вася"
            val password = "12345"
            val repeatPassword = "67890"
            assertThat(AuthUtil.signUp(userName, password, repeatPassword)).isFalse()
        }

        //Функция не должна допускать passwords длиной менее двух символов
        @Test
        fun `signUp function returns false when password is less than two characters`() {
            val userName = "Борис"
            val password = "1"
            val repeatPassword = "1"
            assertThat(AuthUtil.signUp(userName, password, repeatPassword)).isFalse()
        }
    }

}