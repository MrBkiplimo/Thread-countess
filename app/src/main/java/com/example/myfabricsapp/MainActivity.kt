package com.example.myfabricsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView



class MainActivity : AppCompatActivity() {
    private var cardOne : CardView ?= null
    var cardTwo : CardView ?= null
    var cardThree : CardView ?= null

    var cardFour : CardView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardOne = findViewById(R.id.card_a)
        cardTwo = findViewById(R.id.card_b)
        cardThree = findViewById(R.id.card_c)

        cardFour= findViewById(R.id.card_d)

        cardOne!!.setOnClickListener {

            val goToAdd = Intent(applicationContext, SellActivity::class.java)
            startActivity(goToAdd)

        }

        cardTwo!!.setOnClickListener {

            startActivity(Intent(applicationContext,ShopActivity::class.java))

        }

        cardThree!!.setOnClickListener {

            Toast.makeText(this,"Feature not yet implemented, kindly check back soon!",Toast.LENGTH_SHORT).show()

        }
        cardFour!!.setOnClickListener {

//            Toast.makeText(this,"More Actions" +
//                    " Activity",Toast.LENGTH_SHORT).show()

        }




    }
}