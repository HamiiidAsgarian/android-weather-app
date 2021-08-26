package com.example.test1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class PageAdaptor(fm: FragmentManager, lifecycle: Lifecycle, fr1:Fragment1,fr2:Fragment2):FragmentStateAdapter(fm, lifecycle) {





     var one = fr1
     var two = fr2


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                return one;
            }
            1 -> {
                return two
            }

           else -> one
       }
    }


}