package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.thedroidcamp.qvid19.R
import kotlinx.android.synthetic.main.fragment_prevention.*

class PreventionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater,
            //R.layout.fragment_prevention, container, false)

        return inflater.inflate(R.layout.fragment_prevention, container, false)
    }
}