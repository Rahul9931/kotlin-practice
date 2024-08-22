package com.example.kotlin_practice2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.FragmentHomeFragmentBinding

class Home_fragment : Fragment() {
    private lateinit var binding: FragmentHomeFragmentBinding
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
        binding = FragmentHomeFragmentBinding.inflate(inflater, container, false)
        var navControler = findNavController()
        binding.sendMoney.setOnClickListener {
            var action = Home_fragmentDirections.actionHomeFragment2ToChooseReceiverFragment()
            navControler.navigate(action)
        }

        return binding.root
    }

    companion object {

    }
}