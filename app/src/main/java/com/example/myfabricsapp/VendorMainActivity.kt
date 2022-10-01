package com.example.myfabricsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class VendorMainActivity : AppCompatActivity() {

    var cardOne : CardView?= null
    var cardTwo : CardView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_main)

        cardOne = findViewById(R.id.card_a)
        cardTwo = findViewById(R.id.card_b)


        cardOne!!.setOnClickListener {


            startActivity(Intent(applicationContext,SellActivity::class.java))

        }
        cardTwo!!.setOnClickListener {

            Toast.makeText(baseContext, "Access Denied " +
                    "Register as a Customer in Order to View !",
                Toast.LENGTH_SHORT).show()
        }
    }
}