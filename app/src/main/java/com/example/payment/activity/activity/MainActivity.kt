package com.example.payment.activity.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.payment.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    fun initViews(){
        val paymentPageButton = findViewById<Button>(R.id.btn_openPaymentPage)

        paymentPageButton.setOnClickListener {
            openPaymentPage()
        }
    }
    fun openPaymentPage(){
        startActivity(Intent(this, Payment::class.java))
    }
}