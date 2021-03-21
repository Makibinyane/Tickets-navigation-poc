package com.example.ticketapplicationpoc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TicketAdapter(private val onClick: (Ticket) -> Unit) :
    ListAdapter<Ticket, TicketAdapter.TicketViewHolder>(TicketDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder =
        TicketViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.ticket_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ticketTitle: TextView = itemView.findViewById(R.id.txtTitle)
        private val ticketDesc: TextView = itemView.findViewById(R.id.txtDescription)


        fun bind(ticket: Ticket) {
            ticketTitle.text = ticket.ticketTitle
            ticketDesc.text = ticket.ticketDescription

            itemView.setOnClickListener {
                onClick(ticket)
            }
        }
    }

    class TicketDiffUtil : DiffUtil.ItemCallback<Ticket>() {
        override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
            return oldItem.ticketTitle == newItem.ticketTitle
                    && oldItem.ticketDescription == newItem.ticketDescription
        }

        override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
            return oldItem == newItem
        }
    }
}