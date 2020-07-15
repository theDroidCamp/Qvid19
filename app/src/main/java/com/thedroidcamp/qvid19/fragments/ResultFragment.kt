package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.MainActivity
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_result, container, false
        )

        printFinalScore()
        setFragmentToOriginalState()

        return binding.root
    }

    fun printFinalScore() {
        mainActivity = context as MainActivity
        val finalScore = mainActivity.getScore()
        binding.resultScoreNumber.text = finalScore.toString()
    }

    fun setFragmentToOriginalState() {
        binding.resultFragButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_resultFragment_to_questionOneFragment
            )
        )
        mainActivity.clearQNAs()
    }

}
