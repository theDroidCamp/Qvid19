package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentTreatmentsBinding
import com.thedroidcamp.qvid19.treatment

class TreatmentsFragment : Fragment() {

    private lateinit var binding: FragmentTreatmentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_treatments, container, false
        )

        binding.treatmentsFragmentText.text = treatment

        binding.treatmentsFragmentPreviousButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_treatmentsFragment_to_preventionFragment)
        )

        binding.treatmentsFragmentNextButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_treatmentsFragment_to_hoorayFragment)
        )


        return binding.root
    }

}