package com.example.themoviedb.adapters
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.themoviedb.ui.home.FilmsListFragment
import com.example.themoviedb.ui.home.FilmsTableFragment

val fragmentTitleList = mutableListOf("New Films","All Films")

class MyPagerAdapter(fm: FragmentManager, private val fragmentCount:Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FilmsListFragment()
            1 -> FilmsTableFragment()
            else -> getItem(position)
        }
    }

    override fun getCount(): Int = fragmentCount

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]

    }
}