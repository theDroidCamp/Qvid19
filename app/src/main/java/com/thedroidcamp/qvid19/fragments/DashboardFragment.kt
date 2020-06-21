package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.thedroidcamp.qvid19.MainActivity
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentDashboardBinding

/**
 * A simple [Fragment] subclass..
 */
class DashboardFragment : Fragment() {


    lateinit var navController: NavController
    private lateinit var _binding: FragmentDashboardBinding

    //region Codes added by Mridul Baishya, In case of any issue inform me
    lateinit var mainActivity: MainActivity // added by Mridul Baishya
    //endregion

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dashboard,
            container, false
        )

        _binding.readMoreButton.setOnClickListener { readMore() }
        _binding.takeQuizButton.setOnClickListener { takeQuiz() }

        //region Codes added by Mridul Baishya, If found any issue please inform me
        mainActivity = context as MainActivity // added by Mridul Baishya
        mainActivity.clearQNAs() // added by Mridul Baishya
        //endregion

        // Inflate the layout for this fragment
        return _binding.root
    }

    private fun takeQuiz() {
        navController.navigate(DashboardFragmentDirections.actionDashboardFragmentToQuestionOneFragment())
    }

    private fun readMore() {
        navController.navigate(DashboardFragmentDirections.actionDashboardFragmentToAboutFragment())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)


    }


}