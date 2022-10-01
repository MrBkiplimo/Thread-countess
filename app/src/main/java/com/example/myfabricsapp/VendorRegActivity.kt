package com.example.myfabricsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class VendorRegActivity : AppCompatActivity() {

    var buttonRegister: Button? = null

    var textlogin: TextView? = null
    //    Firebase
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_reg)
        // Initialize Firebase Auth
        auth = Firebase.auth

        textlogin = findViewById(R.id.gotoLogin)
        buttonRegister = findViewById(R.id.btnRegister)


        textlogin!!.setOnClickListener {
            val goToLoginIntent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(goToLoginIntent)

        }

        buttonRegister!!.setOnClickListener {

            performsignup()

        }

    }


    private fun performsignup() {
        val email =findViewById<EditText>(R.id.inputEmail)
        val password =findViewById<EditText>(R.id.inputPassword)

        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        if (inputEmail.isEmpty() || inputPassword.isEmpty()){


            Toast.makeText(this,"Kindly Fill All Fields!", Toast.LENGTH_SHORT).show()

            return

        }


        auth.createUserWithEmailAndPassword(inputEmail , inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, lets move to the next Activity
                    val intent = Intent(applicationContext, VendorMainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Registration Successful",
                        Toast.LENGTH_SHORT).show()

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed. Try Again !",
                        Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener {
                Toast.makeText(this,"Error occurred ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
    }


}