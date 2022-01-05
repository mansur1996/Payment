package com.example.payment.activity.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.payment.R

class Status : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        initViews()
    }
    fun initViews(){
        val successButton = findViewById<Button>(R.id.btn_success)
        val failedButton = findViewById<Button>(R.id.btn_failed)

        successButton.setOnClickListener {
            openHomePage()
        }

        failedButton.setOnClickListener {
            openConfirmPage()
        }
    }
    private fun openHomePage(){
        val intent = Intent()
        intent.putExtra("statusResult", "success")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
    private fun openConfirmPage(){
        val intent = Intent()
        intent.putExtra("statusResult", "fail")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}