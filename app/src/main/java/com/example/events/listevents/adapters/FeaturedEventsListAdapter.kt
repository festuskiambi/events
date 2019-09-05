package com.example.events.listevents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.events.R
import com.example.events.common.EventDiffCallBack
import com.example.events.domain.entities.Event
import kotlinx.android.synthetic.main.item_fetured_events.view.*

/**
 * Created by Festus Kiambi on 9/5/19.
 */

class FeaturedEventsListAdapter :
    ListAdapter<Event, FeaturedEventsListAdapter.FeaturedEventViewHolder>(EventDiffCallBack()) {
    override fun onBindViewHolder(holder: FeaturedEventsListAdapter.FeaturedEventViewHolder, position: Int) {
        getItem(position).let { event ->
            val date = "${event.date!!.take(3)}\n${event.date.drop(4)}"
            holder.title.text = event.title
            holder.location.text = event.location
            holder.date.text = date

            val radius = holder.itemView.context.resources.getDimensionPixelSize(R.dimen.corner_radius)
            val myOptions = RequestOptions()
                .override(600, 200)



            Glide.with(holder.itemView.context)
                .load(event.imageUrl)
                .apply(myOptions.transform(RoundedCorners(radius)))
                .into(holder.image)

//            holder.favorite.setOnClickListener {
//                viewModel.addBookMark(rockStar)
//            }
        }    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedEventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FeaturedEventViewHolder(
            inflater.inflate(R.layout.item_fetured_events, parent, false)
        )
    }


    class FeaturedEventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.txt_featured_title
        val location: TextView = view.txt_featured_location
        val image: ImageView = view.iv_featured_event
        val date: TextView = view.tv_featured_date
    }
}