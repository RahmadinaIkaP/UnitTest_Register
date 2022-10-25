package binar.academy.chapter7_testing

class Register {

    private val existingName = listOf("Budi", "Doremi", "Kucing", "Garong")
    private val existingGmail = listOf("abc@gmail.com", "user@hotmail.com", "testing@gmail.com")

    fun validateRegistrationInput(name : String, email : String, password : String, confirmedPassword : String) : Boolean{
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()){
            return false
        }
        if (name in existingName){
            return false
        }
        if (password != confirmedPassword){
            return false
        }
        if (password.count { it.isDigit() } < 2){
            return false
        }
        if (email in existingGmail){
            return false
        }
        if (password.count{it.isDigit()} < 6){
            return false
        }
        if (password.count{it.isDigit()} > 50){
            return false
        }
        return true
    }
}