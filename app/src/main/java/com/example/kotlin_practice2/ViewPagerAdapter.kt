package com.example.kotlin_practice2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlin_practice2.fragments.Chat_fragment
import com.example.kotlin_practice2.fragments.Home_fragment
import com.example.kotlin_practice2.fragments.Profile_fragment

class ViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Home_fragment()
            1 -> Chat_fragment()
            else-> Profile_fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Home"
            1 -> "Chat"
            else -> "Profile"
        }
    }
}