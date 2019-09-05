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


class ListEventsActivity : AppCompatActivity() {

    private val viewModel: EventsViewModel by viewModel()

    lateinit var eventsAdapter: EventListAdapter
    lateinit var featuredEventsAdapter: FeaturedEventsListAdapter
    lateinit var favoritesAdapter: FavoriteListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_events)

        if (NetworkConnectivity(this).isConnected()) {
            initView()
        } else {
            Toast.makeText(this, "Check your network connection and retry", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun initView() {
        setupAdapters()
        observeViewModel()
    }

    private fun setupAdapters() {
        eventsAdapter = EventListAdapter()
        rv_more_events.adapter = eventsAdapter

        val horizontalLayoutManagaer =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        featuredEventsAdapter = FeaturedEventsListAdapter()
        rv_featured_events.layoutManager = horizontalLayoutManagaer
        rv_featured_events.adapter = featuredEventsAdapter

        favoritesAdapter = FavoriteListAdapter()
        rv_favorites.adapter = favoritesAdapter
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
                    favoritesAdapter.submitList(result.subList(0,3))

                }
            }
        )
    }
}
