package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentSymptomsBinding

class SymptomsFragment : Fragment() {

    private lateinit var binding: FragmentSymptomsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_symptoms, container, false
        )

        binding.signsPrevBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_symptomsFragment_to_aboutFragment)
        )
        binding.signsNxtBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener
                (R.id.action_symptomsFragment_to_preventionFragment)
        )
        return binding.root
    }
}



