package com.cz.czbazzar.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.cz.czbazzar.databinding.FragmentProfileBinding

class profile : Fragment() {
    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }
    private fun setUpBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (isEnabled){
                    Toast.makeText(requireContext(),"back", Toast.LENGTH_SHORT).show()
                    isEnabled=false
                    requireActivity().onBackPressed()
                }
            }
        })
    }


}