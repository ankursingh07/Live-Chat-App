package com.example.chateru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.chateru.ui.FragmentGetStarted
import com.example.chateru.ui.FragmentLogin
import com.example.chateru.ui.FragmentSignUp
import com.example.chateru.utils.Navigation
import com.example.chateru.viewmodel.NavigationViewModel

class BaseActivity : AppCompatActivity() {

    private val navigationViewModel = NavigationViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        navigationViewModel.showGetStartedFragment()
    }

    init {
        initObserver()
    }

    private fun initObserver(){
        navigationViewModel.getNavigation().observe(this) {
            it?.let {
                handleNavigation(navigation = it)
            }
        }
    }

    private fun handleNavigation(navigation: Navigation){
        when(navigation){

            Navigation(Navigation.SHOW_GET_STARTED_FRAGMENT) -> {
                showFragment(FragmentGetStarted())
            }

            Navigation(Navigation.HIDE_GET_STARTED_FRAGMENT) -> {
                hideFragment(FragmentGetStarted())
            }

            Navigation(Navigation.SHOW_LOGIN_FRAGMENT) -> {
                showFragment(FragmentLogin())
            }

            Navigation(Navigation.HIDE_LOGIN_FRAGMENT) -> {
                hideFragment(FragmentLogin())
            }

            Navigation(Navigation.SHOW_SIGNUP_FRAGMENT) -> {
                showFragment(FragmentSignUp())
            }

            Navigation(Navigation.HIDE_SIGNUP_FRAGMENT) -> {
                hideFragment(FragmentSignUp())
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