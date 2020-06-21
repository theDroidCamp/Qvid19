package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentHoorayBinding
import com.thedroidcamp.qvid19.databinding.FragmentPreventionBinding
import com.thedroidcamp.qvid19.hooray

class HoorayFragment : Fragment() {

    private lateinit var binding: FragmentHoorayBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_hooray, container, false)

        binding.hoorayFragmentText.text = hooray

        binding.hoorayFragmentTakeQuizButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_hoorayFragment_to_questionOneFragment)
        )

        return binding.root
    }
}

