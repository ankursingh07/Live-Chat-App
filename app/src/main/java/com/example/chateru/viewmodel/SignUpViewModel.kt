package com.example.chateru.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chateru.utils.AppConstants

class SignUpViewModel : ViewModel(){

    private val logInState = MutableLiveData<Int>(AppConstants.LoginStates.Logging_In_Idle)
    private val email = MutableLiveData<String>()
    private val password = MutableLiveData<String>()
    private val confirmPassword = MutableLiveData<String>()
    private val username = MutableLiveData<String>()

    fun getLogInState() : LiveData<Int> = logInState

    fun getEmail() : LiveData<String> = email

    fun getPassword() : LiveData<String> = password

    fun getConfirmPassword() : LiveData<String> = confirmPassword

    fun getUsername() : LiveData<String> = password

    fun setLogInState(currentLogInState : Int) {
        logInState.value = currentLogInState
    }

    fun setEmail(currentEmail : String) {
        email.value = currentEmail
    }

    fun setPassword(currentPassword : String) {
        password.value = currentPassword
    }

    fun setConfirmPassword(currentConfirmPassword : String) {
        confirmPassword.value = currentConfirmPassword
    }

    fun setUsername(currentUsername : String) {
        username.value = currentUsername
    }

    fun startLogIn(){

    }
}