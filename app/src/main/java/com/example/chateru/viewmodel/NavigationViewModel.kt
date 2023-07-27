package com.example.chateru.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chateru.utils.Navigation

class NavigationViewModel : ViewModel() {

    private val mNavigation = MutableLiveData<Navigation>()

    fun getNavigation() : LiveData<Navigation> = mNavigation

    fun showGetStartedFragment() {
        mNavigation.value = Navigation(Navigation.SHOW_GET_STARTED_FRAGMENT)
    }

    fun hideGetStartedFragment() {
        mNavigation.value = Navigation(Navigation.HIDE_GET_STARTED_FRAGMENT)
    }

    fun showLoginFragment() {
        mNavigation.value = Navigation(Navigation.SHOW_LOGIN_FRAGMENT)
    }

    fun hideLoginFragment() {
        mNavigation.value = Navigation(Navigation.HIDE_LOGIN_FRAGMENT)
    }

    fun showSignUpFragment() {
        mNavigation.value = Navigation(Navigation.SHOW_SIGNUP_FRAGMENT)
    }

    fun hideSignUpFragment() {
        mNavigation.value = Navigation(Navigation.HIDE_SIGNUP_FRAGMENT)
    }

}