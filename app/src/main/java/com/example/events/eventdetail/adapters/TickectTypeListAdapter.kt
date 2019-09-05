package com.example.events.eventdetail.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.example.events.R
import com.example.events.common.TickectTypeDiffCallBack
import com.example.events.domain.entities.TicketType
import kotlinx.android.synthetic.main.item_tickect_type.view.*

/**
 * Created by Festus Kiambi on 9/6/19.
 */
class TickectTypeListAdapter :
    ListAdapter<TicketType, TickectTypeListAdapter.TicketTypeViewHolder>(TickectTypeDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketTypeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TicketTypeViewHolder(
            inflater.inflate(R.layout.item_tickect_type, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TicketTypeViewHolder, position: Int) {
        getItem(position).let { ticketType ->
            holder.title.text = ticketType.title
            holder.price.text = ticketType.price.toString()
            holder.count.text = "0"
            holder.date.text = ticketType.closeDate
        }
    }

    class TicketTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tv_tickect_type_title
        val price: TextView = view.tv_tickect_type_price
        val count: TextView = view.tv_tickect_count
        val date :TextView = view.tv_close_date
    }
}