package com.example.kotlin_practice2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.FragmentChooseReceiverBinding
import com.example.kotlin_practice2.databinding.FragmentHomeFragmentBinding
import com.example.kotlin_practice2.model.Student

class chooseReceiverFragment : Fragment() {
    private lateinit var binding:FragmentChooseReceiverBinding
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
        binding = FragmentChooseReceiverBinding.inflate(inflater,container,false)
        val student = Student(1,"rahul saini")
        val list = arrayOf(
            Student(1,"super"),
            Student(2,"goku"),
            Student(3,"ultra"),
        )
        binding.btnNext.setOnClickListener {
            var receiverName = binding.edtReceiverName.text.toString()
            val action  = chooseReceiverFragmentDirections.actionChooseReceiverFragment2ToMessangerFragment3(receiverName,100)
            findNavController().navigate(action)
        }

        return binding.root
    }
}