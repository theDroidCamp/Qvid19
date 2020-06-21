package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentDashboardBinding
import com.thedroidcamp.qvid19.databinding.FragmentTreatmentsBinding
import com.thedroidcamp.qvid19.treatment
import kotlinx.android.synthetic.main.fragment_treatments.*

class TreatmentsFragment : Fragment() {

    private lateinit var binding: FragmentTreatmentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_treatments, container, false)

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