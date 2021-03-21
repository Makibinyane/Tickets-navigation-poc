package com.example.ticketapplicationpoc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class TicketDetailsFragment : Fragment() {

    private val ticketDetailsFragmentArgs: TicketDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_ticket_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ticketTitle: TextView = view.findViewById(R.id.txtTitle)
        val ticketDesc: TextView = view.findViewById(R.id.txtDescription)

        ticketTitle.text = ticketDetailsFragmentArgs.title
        ticketDesc.text = ticketDetailsFragmentArgs.description
    }
}