package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.MainActivity
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentQuestionFourBinding
import com.thedroidcamp.qvid19.databinding.FragmentQuestionTwoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFourFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFourFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    lateinit var navController: NavController
    private lateinit var _binding: FragmentQuestionFourBinding
    private lateinit var mainActivity: MainActivity



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionFourFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionFourFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}