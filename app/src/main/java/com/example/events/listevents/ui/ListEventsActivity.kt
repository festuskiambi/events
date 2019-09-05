package com.example.events.listevents.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.events.common.NetworkConnectivity
import com.example.events.listevents.adapters.EventListAdapter
import com.example.events.listevents.adapters.FeaturedEventsListAdapter
import com.example.events.listevents.viewmodel.EventsViewModel
import kotlinx.android.synthetic.main.activity_list_events.*
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.events.R
import com.example.events.listevents.adapters.FavoriteListAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import android.graphics.drawable.InsetDrawable
import com.example.events.listevents.adapters.CategoryListAdapter


class ListEventsActivity : AppCompatActivity() {

    private val viewModel: EventsViewModel by viewModel()

    lateinit var eventsAdapter: EventListAdapter
    lateinit var featuredEventsAdapter: FeaturedEventsListAdapter
    lateinit var favoritesAdapter: FavoriteListAdapter
    lateinit var categoryAdapter : CategoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_events)

        if (NetworkConnectivity(this).isConnected()) {
            initView()
        } else {
            Toast.makeText(
                this,
                "Check your network connection and retry",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun initView() {
        setupAdapters()
        observeViewModel()
    }

    private fun setupAdapters() {
        setupEventsAdapter()
        setupFavoritesAdapter()
        setupFeaturedEventsAdapter()
        setupCategoriesAdapter()
    }

    private fun setupEventsAdapter() {
        eventsAdapter = EventListAdapter()
        rv_more_events.adapter = eventsAdapter
    }

    private fun setupFavoritesAdapter() {
        favoritesAdapter = FavoriteListAdapter()
        rv_favorites.adapter = favoritesAdapter

        val ATTRS = intArrayOf(android.R.attr.listDivider)
        val a = this.obtainStyledAttributes(ATTRS)
        val divider = a.getDrawable(0)
        val inset = resources.getDimensionPixelSize(com.example.events.R.dimen.decorator_dimen)
        val insetDivider = InsetDrawable(divider, inset, 0, 0, 0)
        a.recycle()

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        itemDecoration.setDrawable(insetDivider)

        rv_favorites.addItemDecoration(itemDecoration)
    }

    private fun setupFeaturedEventsAdapter() {
        featuredEventsAdapter = FeaturedEventsListAdapter()

        val horizontalLayoutManagaer =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rv_featured_events.layoutManager = horizontalLayoutManagaer
        rv_featured_events.adapter = featuredEventsAdapter
    }

    private fun setupCategoriesAdapter() {
        categoryAdapter = CategoryListAdapter()

        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rv_categories.layoutManager = layoutManager
        rv_categories.adapter = categoryAdapter
    }

    private fun observeViewModel() {
        viewModel.eventsList.observe(
            this,
            Observer { eventList ->
                eventsAdapter.submitList(eventList)

                val featuredEvents = eventList.filter { event -> event.featured == true }

                featuredEventsAdapter.submitList(featuredEvents)
            }
        )

        viewModel.favorite.observe(
            this,
            Observer { favorite ->
                val result = favorite.events
                if (!result.isNullOrEmpty()) {
                    favoritesAdapter.submitList(result.subList(0, 3))
                    val favCount = "(${result.size})"
                    txt_favorites_count.text = favCount
                }
            }
        )

        viewModel.categoryList.observe(
            this,
            Observer { categoryList ->
                categoryAdapter.submitList(categoryList)
            }
        )
    }
}
