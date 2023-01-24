package com.example.fundsindiatask.ui.friends

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fundsindiatask.data.MovieListData
import com.example.fundsindiatask.databinding.FragmentFriendsListBinding
import com.example.fundsindiatask.retrofit.ApiAdapter
import com.example.fundsindiatask.ui.friends.adapter.FriendsListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class FriendsListFragment : Fragment() , CoroutineScope by MainScope() {
    lateinit var fragmentFriendsListBinding: FragmentFriendsListBinding
    private lateinit var friendsListAdapter: FriendsListAdapter
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFriendsListBinding = FragmentFriendsListBinding.inflate(layoutInflater, container, false)
        navController = findNavController()
        launch {

            try {
                val response = ApiAdapter.apiClient.getMovieList()
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!
                    data.let { data ->
                        callAdapter(data)
                    }
                } else {
                    Toast.makeText(
                        requireActivity(),
                        "Error Occurred: ${response.message()}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                Toast.makeText(
                    requireActivity(),
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }

        }
        return fragmentFriendsListBinding.root
    }

    companion object {

        fun newInstance() = FriendsListFragment()
    }

    private fun callAdapter(data: ArrayList<MovieListData>) {

        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        fragmentFriendsListBinding.recyclerviewMovies.setLayoutManager(linearLayoutManager)
        friendsListAdapter = FriendsListAdapter(data,requireActivity(),navController)
        fragmentFriendsListBinding.recyclerviewMovies.setAdapter(friendsListAdapter)
    }


    }