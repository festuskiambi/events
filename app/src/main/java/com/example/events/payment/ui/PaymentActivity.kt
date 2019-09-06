package com.example.events.payment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.events.R
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        rb_card.setOnClickListener {
            rb_card.isChecked = true
            rb_mpesa.isChecked = false
        }

        rb_mpesa.setOnClickListener {
            rb_mpesa.isChecked = true
            rb_card.isChecked = false
        }
    }
}
