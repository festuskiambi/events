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
import com.example.events.common.CategoryDiffCallBack
import com.example.events.domain.entities.Category
import kotlinx.android.synthetic.main.item_category.view.*

/**
 * Created by Festus Kiambi on 9/5/19.
 */
class CategoryListAdapter :
    ListAdapter<Category, CategoryListAdapter.CategoryViewHolder>(CategoryDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(
            inflater.inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        getItem(position).let { category ->
            holder.title.text = category.title


            val radius =
                holder.itemView.context.resources.getDimensionPixelSize(R.dimen.corner_radius_fav)
            val myOptions = RequestOptions()
                .override(600, 200)

            Glide.with(holder.itemView.context)
                .load(category.imageUrl)
                .apply(myOptions.transform(RoundedCorners(radius)))
                .into(holder.image)
        }
    }

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tv_category_title
        val image: ImageView = view.iv_category
    }
}