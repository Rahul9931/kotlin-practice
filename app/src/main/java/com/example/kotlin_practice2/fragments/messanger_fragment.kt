package com.example.kotlin_practice2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlin_practice2.R
import com.example.kotlin_practice2.databinding.FragmentMessangerFragmentBinding

class messanger_fragment : Fragment() {
    private lateinit var binding:FragmentMessangerFragmentBinding
    private val args : messanger_fragmentArgs by navArgs()
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
        binding = FragmentMessangerFragmentBinding.inflate(inflater,container,false)

        val receiverName = "Cash send to "+args.receiverName
        binding.receivername.text = receiverName
        Log.d("check_1","${args.student.name}")
        Log.d("check_2","${args.listOfStudent.contentToString()}")
        Log.d("check_2","${args.listOfStudent.get(0).name}")

        binding.btnCancel.setOnClickListener {
            val action = messanger_fragmentDirections.actionMessangerFragment2ToHomeFragment2()
            findNavController().navigate(action)
        }
        return binding.root
    }
}