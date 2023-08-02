package com.example.chateru.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chateru.R
import com.example.chateru.databinding.FragmentConversationBinding
import com.example.chateru.databinding.FragmentHomeBinding
import com.example.chateru.viewmodel.NavigationViewModel

class FragmentConversation : Fragment() , AdapterConversation.OnItemClickListener{

    private val navigationViewModel: NavigationViewModel by activityViewModels()

    private var _binding: FragmentConversationBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConversationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvConversation.adapter= AdapterConversation(this)
        binding.rvConversation.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initClickListener(){
        binding.root.setOnClickListener{
            Toast.makeText(requireContext(),"Clicked on Login", Toast.LENGTH_LONG).show()
        }

    }

    override fun onItemClick(position: Int) {

    }

    override fun onDeleteClick(position: Int) {

    }
}