package com.example.chateru.di

import com.example.chateru.viewmodel.LoginViewModel
import com.example.chateru.viewmodel.NavigationViewModel
import org.koin.dsl.module

val appModule = module {
    single {
        NavigationViewModel()
    }
    single {
        LoginViewModel()
    }
}