package com.example.chateru.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.chateru.R
import com.example.chateru.databinding.FragmentGetStartedBinding
import com.example.chateru.databinding.FragmentSignUpBinding
import com.example.chateru.viewmodel.NavigationViewModel

class FragmentSignUp : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun initClickListener() {
        binding.btnSignupBack.setOnClickListener {
            navigationViewModel.showLoginFragment()
            Toast.makeText(requireContext(),"Clicked on Back Button",Toast.LENGTH_LONG).show()
        }
        binding.btnSignup.setOnClickListener {
            navigationViewModel.showHomeFragment()
            Toast.makeText(requireContext(),"Clicked on Sign Up Button",Toast.LENGTH_LONG).show()
        }

    }

}