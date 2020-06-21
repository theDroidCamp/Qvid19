package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.aboutCovid19
import com.thedroidcamp.qvid19.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)

        binding.aboutText.text = aboutCovid19

        binding.buttonPrev.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_aboutFragment_to_dashboardFragment)
        )

        binding.buttonNext.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_aboutFragment_to_symptomsFragment)
        )

        return binding.root
    }
}
