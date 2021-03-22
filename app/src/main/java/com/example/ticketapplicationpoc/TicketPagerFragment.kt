package com.example.ticketapplicationpoc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.UnsupportedOperationException


class TicketPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_ticket_pager, container, false)

        val tab_viewpager = view.findViewById<ViewPager2>(R.id.tab_viewpager)
        val tab_tablayout = view.findViewById<TabLayout>(R.id.tab_tablayout)

        setupViewPager(tab_viewpager)
        TabLayoutMediator(tab_tablayout, tab_viewpager) { tab, position ->
            tab.text = when(position){
                0 -> "Open"
                1 -> "Closed"
                else -> "Unknown"
            }
        }.attach()
        return view
    }

    private fun setupViewPager(viewpager: ViewPager2) {
        activity?.let {
            viewpager.adapter = ViewPagerAdapter(it)
        }
    }

    class ViewPagerAdapter
        (activity: FragmentActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int {
            return 2
        }
        override fun createFragment(position: Int): Fragment {
            return when (position){
                0 -> OpenTicketFragment()
                1-> ClosedTicketFragment()
                else -> OpenTicketFragment()
            }
        }
    }

}