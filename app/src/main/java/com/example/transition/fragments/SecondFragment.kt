package com.example.transition.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.transition.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTranData()
        retranClickListener()
    }

    private fun getTranData() {
        val data = args.text
        binding.textV2.text = data
    }

    private fun retranClickListener() {
        binding.floatingTransitionV2.setOnClickListener() {
            val reData = binding.textV2.text.toString()
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment(reData)
            findNavController().navigate(action)
        }
    }
}