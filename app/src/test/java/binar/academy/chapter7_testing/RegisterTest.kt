package binar.academy.chapter7_testing

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class RegisterTest{

    lateinit var regis : Register

    @Before
    fun setUp(){
        regis = Register()
    }

    @Test
    fun emailEmpty_false(){
        val result = regis.validateRegistrationInput("Dina", "", "abc123", "abc123")
        assertEquals("Email is empty!", result, false)
    }

    @Test
    fun passEmpty_false(){
        val result = regis.validateRegistrationInput("Dina", "rahmadinaikaputri@gmail.com", "", "abc123")
        assertEquals("Email is empty!", result, false)
    }

    @Test
    fun nameExist(){
        val result = regis.validateRegistrationInput("Budi", "budidoremi@gmail.com", "akuaku", "akuaku")
        assertEquals("Name already exist!", result, false)
    }

    @Test
    fun emailExist(){
        val result = regis.validateRegistrationInput("User", "user@hotmail.com", "akuaku", "akuaku")
        assertEquals("Email already exist!", result, false)
    }

    @Test
    fun passwordKurangDariEnam(){
        val result = regis.validateRegistrationInput("User", "user@hotmail.com", "abc", "abc")
        assertEquals("Password is to short!", result, false)
    }

    @Test
    fun passwordLebihdariLimaPuluh(){
        val result = regis.validateRegistrationInput("User", "user@hotmail.com",
            "akuakuakuakauakaukauakauakauakuakauakuakauakauauakakauauakakaaua",
            "akuakuakuakauakaukauakauakauakuakauakuakauakauauakakauauakakaaua")
        assertEquals("Password cannot be longer than 50!", result, false)
    }
}