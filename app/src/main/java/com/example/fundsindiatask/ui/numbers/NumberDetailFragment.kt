package com.example.fundsindiatask.ui.numbers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fundsindiatask.R
import com.example.fundsindiatask.databinding.FragmentNumberDetailBinding
import com.example.fundsindiatask.databinding.FragmentNumbersListBinding


class NumberDetailFragment : Fragment() {
    lateinit var numberDetailBinding: FragmentNumberDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        numberDetailBinding =FragmentNumberDetailBinding.inflate(layoutInflater, container, false)
        numberDetailBinding.summaryText.text = arguments?.getString("number")
        return numberDetailBinding.root
    }



}