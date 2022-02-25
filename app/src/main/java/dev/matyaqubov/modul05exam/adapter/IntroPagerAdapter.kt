package dev.matyaqubov.modul05exam.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class IntroPagerAdapter (private val fr: FragmentManager) : FragmentPagerAdapter(fr) {
    private val fragments = ArrayList<Fragment>()

    fun add(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}