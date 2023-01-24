package com.example.fundsindiatask.ui.numbers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fundsindiatask.databinding.NumberListItemBinding
import com.example.fundsindiatask.ui.numbers.NumberDetailListener

class NumberListAdapter(private val mListener: NumberDetailListener): RecyclerView.Adapter<NumberListAdapter.ViewHolder?>() {

    inner class ViewHolder(val binding: NumberListItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener(){
                mListener?.onItemClick(adapterPosition)
            }
        }
                           }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NumberListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){

                binding.numberText.text = position.toString()

        }
    }

    override fun getItemCount(): Int {
        return 10
    }


}