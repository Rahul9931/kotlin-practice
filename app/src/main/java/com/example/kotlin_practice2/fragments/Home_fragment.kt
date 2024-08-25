package com.example.kotlin_practice2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.FragmentHomeFragmentBinding

class Home_fragment : Fragment() {
    private lateinit var binding: FragmentHomeFragmentBinding
    lateinit var navController:NavController
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
        navController = findNavController()
        binding.btnSendMoney.setOnClickListener {
            val action = Home_fragmentDirections.actionHomeFragment3ToChooseReceiverFragment2()
            navController.navigate(action)
        }
        binding.btnViewBalance.setOnClickListener {
            val action = Home_fragmentDirections.actionHomeFragment3ToProfileFragment3()
            navController.navigate(action)
        }
        binding.btnViewTransition.setOnClickListener {
            val navOption = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setEnterAnim(R.anim.slide_out_left)
                .setEnterAnim(R.anim.slide_in_left)
                .setEnterAnim(R.anim.slide_out_right)
                .build()
            navController.navigate(R.id.chat_fragment3,null, navOption)
        }
        return binding.root
    }
}