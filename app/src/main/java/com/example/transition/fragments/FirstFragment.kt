package com.example.transition.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.transition.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val args: FirstFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tranClickListener()
        getReTranData()
    }

    private fun tranClickListener() {
        binding.floatingTransitionV1.setOnClickListener() {
            val data = binding.editTextV1.text.toString()
            if (data.trim().isEmpty()) {
                Toast.makeText(requireContext(), "Поле не может быть пустым", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val args = FirstFragmentDirections.actionFirstFragmentToSecondFragment(data)
                findNavController().navigate(args)
            }
        }
    }

    private fun getReTranData() {
        val reData = args.returnText
        binding.textV1.text = reData
    }
}