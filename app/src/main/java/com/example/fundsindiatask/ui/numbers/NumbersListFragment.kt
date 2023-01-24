package com.example.fundsindiatask.ui.numbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fundsindiatask.R
import com.example.fundsindiatask.databinding.FragmentNumbersListBinding
import com.example.fundsindiatask.ui.numbers.adapter.NumberListAdapter

class NumbersListFragment : Fragment(),NumberDetailListener {
    lateinit var numbersListBinding: FragmentNumbersListBinding
    private lateinit var numberListAdapter: NumberListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        numbersListBinding = FragmentNumbersListBinding.inflate(layoutInflater, container, false)
        callAdapter()
        return numbersListBinding.root
    }
    companion object {
        fun newInstance() = NumbersListFragment()
    }
    private fun callAdapter() {

        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        numbersListBinding.recyclerviewNumbers.setLayoutManager(linearLayoutManager)
        numberListAdapter = NumberListAdapter(this)
        numbersListBinding.recyclerviewNumbers.setAdapter(numberListAdapter)
    }

    override fun onItemClick(position: Int) {
        moveToDetail(position)
    }
    fun moveToDetail(position: Int){
        if(findNavController().currentDestination?.id==R.id.numbersFragment) {
            val bundle = Bundle()
            bundle.putString("number", position.toString())
            findNavController().navigate(R.id.action_numbersFragment_to_numberDetailFragment, bundle)
        }
    }
}