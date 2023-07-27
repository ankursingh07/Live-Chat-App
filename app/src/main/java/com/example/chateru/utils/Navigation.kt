package com.example.chateru.utils

class Navigation(private val mNavigation: Int) {

    companion object {
        const val SHOW_GET_STARTED_FRAGMENT = 1
        const val HIDE_GET_STARTED_FRAGMENT = 2

        const val SHOW_LOGIN_FRAGMENT = 3
        const val HIDE_LOGIN_FRAGMENT = 4

        const val SHOW_SIGNUP_FRAGMENT = 5
        const val HIDE_SIGNUP_FRAGMENT = 6
    }

    fun getNavigation(): Int {
        return mNavigation
    }
}