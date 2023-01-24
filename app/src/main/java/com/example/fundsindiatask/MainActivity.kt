package com.example.fundsindiatask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fundsindiatask.databinding.ActivityMainBinding
import com.example.fundsindiatask.ui.friends.FriendsListFragment
import com.example.fundsindiatask.ui.numbers.NumbersListFragment
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var navGraph: NavGraph
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setSupportActionBar(activityMainBinding.toolbar)

        activityMainBinding.viewPager.adapter = FragmentAdapter(this)

        TabLayoutMediator(activityMainBinding.tabs, activityMainBinding.viewPager){tab, position ->
            tab.text = "Tab ${position}"
        }.attach()


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


        val graphInflater = navHostFragment.navController.navInflater
        navGraph = graphInflater.inflate(R.navigation.nav_graph)

    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> FriendsListFragment.newInstance()
                1 -> NumbersListFragment.newInstance()
                else -> FriendsListFragment.newInstance()
            }
        }

    }
}