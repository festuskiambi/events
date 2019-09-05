package com.example.events.eventdetail.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.events.R
import com.example.events.domain.entities.Event

class EventDetailActivity : AppCompatActivity() {

    lateinit var event: Event


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        initView()
    }

    private fun initView() {

        setupTicketTypeAdapter()
    }

    private fun setupTicketTypeAdapter() {
    }
}
