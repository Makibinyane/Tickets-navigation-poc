package com.example.ticketapplicationpoc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class OpenTicketFragment : Fragment() {

    val tickets = arrayListOf(Ticket("Unable to login", "When using Chrome Browser to login I get 404 error"),
        Ticket("Background Task", "The app is always running as the background task"),
        Ticket("Create Account", "System doesn't allow my phone numbers"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_open_ticket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ticketAdapter = TicketAdapter { item -> handleClick(item) }
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.apply {
            itemAnimator = DefaultItemAnimator()
            adapter = ticketAdapter
        }
        ticketAdapter.submitList(tickets)
    }

    private fun handleClick(ticket: Ticket) {
        findNavController().navigate(TicketPagerFragmentDirections.actionTicketPagerFragmentToTicketDetailsFragment(ticket.ticketTitle, ticket.ticketDescription))
    }
}