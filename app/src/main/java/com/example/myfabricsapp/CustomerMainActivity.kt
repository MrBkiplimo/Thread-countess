package com.example.myfabricsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class CustomerMainActivity : AppCompatActivity() {

     var cardOne : CardView?= null
    var cardTwo : CardView ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_main)

        cardOne = findViewById(R.id.card_a)
        cardTwo = findViewById(R.id.card_b)


        cardOne!!.setOnClickListener {

//
//
//            Toast.makeText(baseContext, "Access Denied " +
//                    "Register as a vendor in order Add products!",
//                Toast.LENGTH_SHORT).show()

        }
        cardTwo!!.setOnClickListener {

            startActivity(Intent(applicationContext,ShopActivity::class.java))


        }


    }
}