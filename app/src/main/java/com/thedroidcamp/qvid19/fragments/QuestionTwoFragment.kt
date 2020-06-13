package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentQuestionTwoBinding
import kotlinx.android.synthetic.main.fragment_question_two.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionTwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class QuestionTwoFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuestionTwoBinding>(
            inflater, R.layout.fragment_question_two, container, false
        )

        binding.btnNext.setOnClickListener { goToNext() }
        binding.btnPrevious.setOnClickListener { goToPrevious() }
        binding.questionTwo = this
        binding.invalidateAll()
        return binding.root
    }

   private fun goToNext(){
        navController.navigate(QuestionTwoFragmentDirections.actionQuestionTwoFragmentToQuestionThreeFragment())
    }

   private fun goToPrevious(){
        navController.navigate(QuestionTwoFragmentDirections.actionQuestionTwoFragmentToQuestionOneFragment())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)


    }


}