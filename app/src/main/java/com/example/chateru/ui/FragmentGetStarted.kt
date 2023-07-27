package com.example.chateru.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.chateru.databinding.FragmentGetStartedBinding
import com.example.chateru.viewmodel.NavigationViewModel

class FragmentGetStarted : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()

    private var _binding : FragmentGetStartedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGetStartedBinding.inflate(inflater, container, false)
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
        binding.btnGetStarted.setOnClickListener {
            navigationViewModel.showLoginFragment()
            Toast.makeText(requireContext(),"Clicked on Get Started",Toast.LENGTH_LONG).show()
        }
    }

}