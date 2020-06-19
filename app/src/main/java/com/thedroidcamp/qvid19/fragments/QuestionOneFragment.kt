package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.radiobutton.MaterialRadioButton
import com.thedroidcamp.qvid19.MainActivity
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentQuestionOneBinding


/**
 * What I did ?
 *
 *  I completed my part of task in complete my way and I don't know any more easy way to perform this
 *  Initialised MainActivity for my fragment by casting context
 *  then i called some basic functions from the activity,
 *  link, calculating score, getting score and setting radio button's state etc.
 */

class QuestionOneFragment : Fragment() {

    lateinit var navController: NavController
    private lateinit var _binding: FragmentQuestionOneBinding
    private val questionId = 1 //need this because we are using id, not index

    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainActivity =
            context as MainActivity // doing this because running i don't know about how to pass the score to next fragment

        //region add these lines only if wants to apply Material Theme
        val contextThemeWrapper = ContextThemeWrapper(mainActivity, R.style.AppTheme_FullScreen)
        inflater.cloneInContext(contextThemeWrapper)
        //endregion

        _binding = FragmentQuestionOneBinding.inflate(layoutInflater)

        if (mainActivity.q1Answered) {
            _binding.answerGroup.isEnabled = false
            setAllRadioButtonDisable()
            setSelection(mainActivity.qnaList[questionId - 1].answerId)
        }
        return _binding.root
    }

    private fun setSelection(checkedId: Int) {
        _binding.answerGroup.check(checkedId)
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
        if (!mainActivity.q1Answered) { //adding this because of previous next features, not directly but indirectly it's linked
            when (_binding.answerGroup.checkedRadioButtonId) {
                -1 -> return
                _binding.optionThreeRadioBtn.id -> addUpScore()
            }
            //save a state that question one answered already
            mainActivity.setAnswered(
                1,
                _binding.answerGroup.checkedRadioButtonId
            ) //setting answer id 1 as answered and saving selection
        }
        navController.navigate(QuestionOneFragmentDirections.actionQuestionOneFragmentToQuestionTwoFragment())
    }

    private fun addUpScore() {
        mainActivity.calculateScore(10) //giving 10 point for correct answer
    }

}
