package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.MainActivity
import com.thedroidcamp.qvid19.databinding.FragmentQuestionFourBinding

class QuestionFourFragment : Fragment() {


    private lateinit var navController: NavController
    private lateinit var _binding: FragmentQuestionFourBinding
    private lateinit var mainActivity: MainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
         //   param1 = it.getString(ARG_PARAM1)
           // param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentQuestionFourBinding.inflate(layoutInflater)
        mainActivity =
            context as MainActivity
        if (mainActivity.q4Answered) {
            _binding.answerGroup.isEnabled = false
            setAllRadioButtonDisable()
        }
        return _binding.root
    }

    private fun setAllRadioButtonDisable() {
        _binding.optionOneRadioBtn.isEnabled = false
        _binding.optionTwoRadioBtn.isEnabled = false
        _binding.optionThreeRadioBtn.isEnabled = false

    }

    private fun goToNext() {
        navController.navigate(QuestionFourFragmentDirections.actionQuestionFourFragmentToQuestionFiveFragment())
        when (_binding.answerGroup.checkedRadioButtonId) {
            -1 -> return
            _binding.optionThreeRadioBtn.id -> addUpScore()
        }
        mainActivity.setAnswered(4)
    }

    private fun goToPrevious() {
        navController.navigate(QuestionFourFragmentDirections.actionQuestionFourFragmentToQuestionThreeFragment())
    }

    private fun addUpScore() {
        mainActivity.calculateScore(10)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        _binding.scoreView.text = mainActivity.currentScore.toString()
        _binding.nextLink.setOnClickListener { goToNext() }
        _binding.previousLink.setOnClickListener { goToPrevious() }
    }

}