package com.example.payment.activity.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.payment.R

class Confirm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        initViews()
    }
    private fun initViews(){
        val statusPageButton = findViewById<Button>(R.id.btn_statusPage)

        statusPageButton.setOnClickListener {
            openStatusPage()
        }
    }
    private var statusLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            val data : Intent? = result.data
            val result = data!!.getStringExtra("statusResult")

            val intent = Intent()
            intent.putExtra("statusResult", result.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
//            if(result.toString() == "success"){
//                val intent = Intent()
//                intent.putExtra("statusResult", result.toString())
//                setResult(Activity.RESULT_OK, intent)
//                finish()
//            }
//            else if(result.toString()== "fail"){
//                Toast.makeText(this, "Failed in Payment", Toast.LENGTH_SHORT).show()
//            }
        }
    }

    private fun openStatusPage(){
        statusLauncher.launch(Intent(this, Status::class.java))
    }
}