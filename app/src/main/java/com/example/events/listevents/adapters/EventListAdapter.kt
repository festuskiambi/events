package com.example.events.listevents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.events.R
import com.example.events.common.EventDiffCallBack
import com.example.events.domain.entities.Event
import kotlinx.android.synthetic.main.item_event.view.*


/**
 * Created by Festus Kiambi on 9/4/19.
 */
class EventListAdapter :
    ListAdapter<Event, EventListAdapter.NoteViewHolder>(EventDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(
            inflater.inflate(R.layout.item_event, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        getItem(position).let { event ->
            val date = "${event.date!!.take(3)}\n${event.date.drop(4)}"
            holder.title.text = event.title
            holder.location.text = event.location
            holder.date.text = date

            val myOptions = RequestOptions()
                .override(600, 200)

            Glide.with(holder.itemView.context)
                .load(event.imageUrl)
                .into(holder.image)

//            holder.favorite.setOnClickListener {
//                viewModel.addBookMark(rockStar)
//            }
        }
    }

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.txt_event_title
        val location: TextView = view.txt_event_location
        val image: ImageView = view.iv_event_image
        val date: TextView = view.txt_event_date
    }
}