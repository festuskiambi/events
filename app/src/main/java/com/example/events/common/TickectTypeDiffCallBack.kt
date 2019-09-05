package com.example.events.common

import androidx.recyclerview.widget.DiffUtil
import com.example.events.domain.entities.TicketType

/**
 * Created by Festus Kiambi on 9/6/19.
 */

class TickectTypeDiffCallBack : DiffUtil.ItemCallback<TicketType>(){
    override fun areItemsTheSame(oldItem:TicketType, newItem: TicketType): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TicketType, newItem: TicketType): Boolean {
        return oldItem.id == newItem.id
    }

}