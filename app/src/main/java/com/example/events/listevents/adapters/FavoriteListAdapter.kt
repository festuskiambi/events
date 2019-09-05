package com.example.events.listevents.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.events.R
import com.example.events.common.EventDiffCallBack
import com.example.events.domain.entities.Event
import com.example.events.eventdetail.ui.EventDetailActivity
import kotlinx.android.synthetic.main.item_favorite_event.view.*

/**
 * Created by Festus Kiambi on 9/5/19.
 */

class FavoriteListAdapter :
    ListAdapter<Event, FavoriteListAdapter.FavoriteViewHolder>(EventDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FavoriteViewHolder(
            inflater.inflate(R.layout.item_favorite_event, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        getItem(position).let { event ->
            holder.title.text = event.title
            holder.location.text = event.location

            val radius =
                holder.itemView.context.resources.getDimensionPixelSize(R.dimen.corner_radius_fav)
            val myOptions = RequestOptions()
                .override(600, 200)

            Glide.with(holder.itemView.context)
                .load(event.imageUrl)
                .apply(myOptions.transform(RoundedCorners(radius)))
                .into(holder.image)

            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, EventDetailActivity::class.java)
                intent.putExtra("value", event)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            }
        }
    }

    class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tv_favorite_event_title
        val location: TextView = view.tv_favorite_event_location
        val image: ImageView = view.iv_favorite_event
    }
}