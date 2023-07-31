package com.example.chateru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.chateru.ui.FragmentConversation
import com.example.chateru.ui.FragmentGetStarted
import com.example.chateru.ui.FragmentHome
import com.example.chateru.ui.FragmentLogin
import com.example.chateru.ui.FragmentSignUp
import com.example.chateru.utils.Navigation
import com.example.chateru.viewmodel.NavigationViewModel
import org.koin.android.ext.android.inject

class BaseActivity : AppCompatActivity() {

    private val navigationViewModel:  NavigationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        initView()

        initObserver()
    }

    private fun initView() {
        navigationViewModel.showGetStartedFragment()
    }

    private fun initObserver(){
        navigationViewModel.getNavigation().observe(this) {
            it?.let {
                handleNavigation(navigation = it)
            }
        }
    }

    private fun handleNavigation(navigation: Navigation){
        when(navigation.getNavigation()){

            Navigation.SHOW_GET_STARTED_FRAGMENT -> {
                showFragment(FragmentGetStarted())
            }

            Navigation.HIDE_GET_STARTED_FRAGMENT -> {
                hideFragment(FragmentGetStarted())
            }

            Navigation.SHOW_LOGIN_FRAGMENT -> {
                showFragment(FragmentLogin())
            }

            Navigation.HIDE_LOGIN_FRAGMENT -> {
                hideFragment(FragmentLogin())
            }

            Navigation.SHOW_SIGNUP_FRAGMENT -> {
                showFragment(FragmentSignUp())
            }

            Navigation.HIDE_SIGNUP_FRAGMENT -> {
                hideFragment(FragmentSignUp())
            }

            Navigation.SHOW_HOME_FRAGMENT -> {
                showFragment(FragmentHome())
            }

            Navigation.HIDE_HOME_FRAGMENT -> {
                hideFragment(FragmentHome())
            }

            Navigation.SHOW_CONVERSATION_FRAGMENT -> {
                showFragment(FragmentConversation())
            }

            Navigation.HIDE_CONVERSATION_FRAGMENT -> {
                hideFragment(FragmentConversation())
            }

        }
    }

    private fun showFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        supportFragmentManager.commit {
            replace(R.id.main_fragment_container, fragment, fragment::class.simpleName)
            if(addToBackStack) {
                addToBackStack(fragment::class.simpleName)
            }
        }
    }

    private fun hideFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            remove(fragment)
        }
    }
}