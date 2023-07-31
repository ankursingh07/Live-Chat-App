package com.example.chateru.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chateru.R
import com.example.chateru.databinding.FragmentHomeBinding
import com.example.chateru.databinding.FragmentSignUpBinding
import com.example.chateru.viewmodel.NavigationViewModel

class FragmentHome : Fragment() , AdapterHome.OnItemClickListener{

    private val navigationViewModel: NavigationViewModel by activityViewModels()

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun initRecyclerView() {
        binding.rvHome.adapter=  AdapterHome(this)
        binding.rvHome.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

    }

    override fun onItemClick(position: Int) {

    }

    override fun onDeleteClick(position: Int) {
    }
}