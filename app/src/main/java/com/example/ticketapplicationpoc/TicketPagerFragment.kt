package com.example.ticketapplicationpoc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class TicketPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_ticket_pager, container, false)

        val tab_viewpager = view.findViewById<ViewPager>(R.id.tab_viewpager)
        val tab_tablayout = view.findViewById<TabLayout>(R.id.tab_tablayout)

        setupViewPager(tab_viewpager)

        tab_tablayout.setupWithViewPager(tab_viewpager)

        return view
    }

    private fun setupViewPager(viewpager: ViewPager) {
        var adapter = activity?.supportFragmentManager?.let { ViewPagerAdapter(it) }

        adapter?.addFragment(OpenTicketFragment(), "Open")
        adapter?.addFragment(ClosedTicketFragment(), "Closed")

        viewpager.adapter = adapter
    }

    class ViewPagerAdapter// this is a secondary constructor of ViewPagerAdapter class.
        (supportFragmentManager: FragmentManager) :
        FragmentPagerAdapter(supportFragmentManager) {

        private var fragmentList1: ArrayList<Fragment> = ArrayList()
        private var fragmentTitleList1: ArrayList<String> = ArrayList()

        // returns which item is selected from arraylist of fragments.
        override fun getItem(position: Int): Fragment {
            return fragmentList1[position]
        }

        // returns which item is selected from arraylist of titles.
        @Nullable
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList1[position]
        }

        // returns the number of items present in arraylist.
        override fun getCount(): Int {
            return fragmentList1.size
        }

        // this function adds the fragment and title in 2 separate  arraylist.
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }
    }

}