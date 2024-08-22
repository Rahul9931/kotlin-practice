package com.example.kotlin_practice2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlin_practice2.NavGraphDirections
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var binding:FragmentSettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(inflater,container,false)

        binding.btnAboutus.setOnClickListener {
            val action = NavGraphDirections.actionGlobalAboutusFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}