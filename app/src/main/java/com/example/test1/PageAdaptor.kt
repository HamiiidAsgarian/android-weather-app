package com.example.test1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import  androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdaptor(fm:FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fm,lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0->{Fragment1()}
           1->{Fragment2()}

           else -> return  Fragment()
       }
    }


}