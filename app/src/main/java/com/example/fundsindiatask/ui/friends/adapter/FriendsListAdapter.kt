package com.example.fundsindiatask.ui.friends.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fundsindiatask.R
import com.example.fundsindiatask.data.MovieListData
import com.example.fundsindiatask.databinding.ListFriendsItemBinding

class FriendsListAdapter(arrayList: ArrayList<MovieListData>, mContext: Context,navController: NavController) :
    RecyclerView.Adapter<FriendsListAdapter.ViewHolder?>() {
    var arraylist:ArrayList<MovieListData> = arrayList
    private var mContext:Context = mContext
    private var navController:NavController = navController

    inner class ViewHolder(val binding: ListFriendsItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListFriendsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(arraylist[position]){
                binding.movieTitle.text = this.show?.name
                binding.movieLanguage.text = this.show?.language
                    Glide.with(mContext)
                        .load(this.show?.image?.original)
                        .into(binding.img)
                itemView.setOnClickListener(){
                    val bundle = Bundle()
                    bundle.putString("summary", this.show?.summary)
                    navController.navigate(R.id.action_friendsFragment_to_friendDetailFragment,bundle)
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }
}