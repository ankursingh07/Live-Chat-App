package com.example.chateru.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.chateru.R
import com.example.chateru.databinding.FragmentLoginBinding
import com.example.chateru.viewmodel.LoginViewModel
import com.example.chateru.viewmodel.NavigationViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class FragmentLogin : Fragment() {

    val navigationViewModel: NavigationViewModel by activityViewModels()
    val loginViewModel : LoginViewModel by activityViewModels()

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun initObserver() {
        loginViewModel.getLogInState().observe(this) {
            it?.let {

            }
        }
        loginViewModel.getEmail().observe(this) {
            it?.let {

            }
        }
        loginViewModel.getPassword().observe(this) {
            it?.let {

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initClickListener(){
        binding.tvBtnSignup.setOnClickListener{
            navigationViewModel.showSignUpFragment()
            Toast.makeText(requireContext(),"Clicked on Sign Up", Toast.LENGTH_LONG).show()
        }
        binding.btnLogin.setOnClickListener {
            Toast.makeText(requireContext(),"Clicked on Login",Toast.LENGTH_LONG).show()
        }
        binding.btnLoginBack.setOnClickListener {
            navigationViewModel.showGetStartedFragment()
            Toast.makeText(requireContext(),"Clicked on Get Started",Toast.LENGTH_LONG).show()
        }
    }
}