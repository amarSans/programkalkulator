package com.example.storyapp.view.fragmnet

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 2
    }
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->KalkulatorFragment()
            1->ProfilFragment()
            else->throw IllegalArgumentException("invalid Position")
        }
    }
}
