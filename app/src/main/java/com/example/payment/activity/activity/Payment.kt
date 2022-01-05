package com.example.payment.activity.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.payment.R

class Payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        initViews()
    }
    fun initViews(){
        val ConfirmPageButton = findViewById<Button>(R.id.btn_openConfirmPage)

        ConfirmPageButton.setOnClickListener {
            openConfirmPage()
        }
    }
    private var confirmLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result->
        if(result.resultCode == Activity.RESULT_OK){
            val data : Intent? = result.data
            val result = data!!.getStringExtra("statusResult")

            if(result.toString() == "succcess"){
                finish()
            }else if(result.toString() == "fail"){
                Toast.makeText(this, "Failed in Payment", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun openConfirmPage(){
        confirmLauncher.launch(Intent(this, Confirm::class.java))
    }
}