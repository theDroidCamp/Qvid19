package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.MainActivity
import com.thedroidcamp.qvid19.databinding.FragmentQuestionOneBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * What I did ?
 *
 *  I completed my part of task in complete my way and I don't know any more easy way to perform this
 *  Initialised MainActivity for my fragment by casting context
 *  then i called some basic functions from the activity,
 *  link, calculating score, getting score and setting radio button's state etc.
 */


/**
 * A simple [Fragment] subclass.
 * Use the [QuestionOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class QuestionOneFragment : Fragment() {

    lateinit var navController: NavController
    private lateinit var _binding: FragmentQuestionOneBinding

    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
          //  param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentQuestionOneBinding.inflate(layoutInflater)
        mainActivity =
            context as MainActivity // doing this because running i don't know about how to pass the score to next fragment
        if (mainActivity.q1Answered) {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        _binding.nextLink.setOnClickListener { goToNextQuestion() }
        _binding.previousLink.setOnClickListener { goToPrevQuestion() }
        _binding.scoreView.text = mainActivity.currentScore.toString()
    }

    private fun goToPrevQuestion() {
        // as this is the first question fragment I'm just returning from here
        return
    }

    private fun goToNextQuestion() {
        when (_binding.answerGroup.checkedRadioButtonId) {
            -1 -> return
            _binding.optionThreeRadioBtn.id -> addUpScore()
        }
        //save a state that question one answered already
        mainActivity.setAnswered(1) //setting answer id 1 as answered
        navController.navigate(QuestionOneFragmentDirections.actionQuestionOneFragmentToQuestionTwoFragment())
    }

    private fun addUpScore() {
        mainActivity.calculateScore(10) //giving 10 point for correct answer
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionOneFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionOneFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

}
}
