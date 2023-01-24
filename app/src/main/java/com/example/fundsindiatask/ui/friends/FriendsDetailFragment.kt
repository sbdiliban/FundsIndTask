package com.example.fundsindiatask.ui.friends

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fundsindiatask.databinding.FragmentFriendsDetailBinding


class FriendsDetailFragment : Fragment() {
    lateinit var friendsDetailBinding: FragmentFriendsDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        friendsDetailBinding = FragmentFriendsDetailBinding.inflate(layoutInflater, container, false)
        friendsDetailBinding.summaryText.text = arguments?.getString("summary")
        return friendsDetailBinding.root
    }

}