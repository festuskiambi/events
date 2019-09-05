package com.example.events.common

import androidx.recyclerview.widget.DiffUtil
import com.example.events.domain.entities.Category

/**
 * Created by Festus Kiambi on 9/5/19.
 */

class CategoryDiffCallBack : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

}