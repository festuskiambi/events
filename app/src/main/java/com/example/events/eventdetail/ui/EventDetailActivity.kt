package com.example.events.eventdetail.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.events.R
import com.example.events.domain.entities.Event
import com.example.events.eventdetail.adapters.TickectTypeListAdapter
import kotlinx.android.synthetic.main.activity_event_detail.*
import kotlinx.android.synthetic.main.content_event_details.*
import androidx.recyclerview.widget.DividerItemDecoration


class EventDetailActivity : AppCompatActivity() {

    private lateinit var event: Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        initView()
    }

    private fun initView() {
        event = intent.getSerializableExtra("value") as Event
        populateViewWithEventDetails()
        setupTicketTypeAdapter()
    }

    private fun populateViewWithEventDetails() {
        tv_event_detail_title.text = event.title
        val host = "by ${event.host}"
        tv_event_detail_host.text = host
        tv_event_detail_date_time.text = event.date
        tv_event_detail_description.text = event.description
        tv_event_detail_location.text = event.location
        Glide.with(this)
            .load(event.imageUrl)
            .into(toolbar_image)

        collapsing_toolbar.setTitleEnabled(false);
        toolbar.setTitle(event.title)

    }

    private fun setupTicketTypeAdapter() {
        val adapter = TickectTypeListAdapter()
        rv_tickect_types.adapter = adapter

        adapter.submitList(event.ticketTypes)

        val dividerItemDecoration = DividerItemDecoration(
            this,
            DividerItemDecoration.VERTICAL
        )

        rv_tickect_types.addItemDecoration(dividerItemDecoration)

    }
}
