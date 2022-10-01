package com.example.myfabricsapp


import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit  var auth: FirebaseAuth

     var textRegisterA: TextView? = null
     var textRegisterB: TextView? = null
      lateinit var buttonLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        auth = Firebase.auth

        textRegisterA = findViewById(R.id.gotoRegister)
        textRegisterB = findViewById(R.id.gotoCustomerReg)
        buttonLogIn = findViewById(R.id.btnLogin)



        textRegisterA!!.setOnClickListener {


            val goToVendorReg = Intent(applicationContext, VendorRegActivity::class.java)
            startActivity(goToVendorReg)
        }

        textRegisterB!!.setOnClickListener {


            val goToCustomerReg = Intent(applicationContext, CustomerRegActivity::class.java)
            startActivity(goToCustomerReg)
        }

//            val alertDialog = AlertDialog.Builder(this)
//            alertDialog.setTitle("Alert!!")
//            alertDialog.setMessage("Select an action you want to perform")
//            alertDialog.setNegativeButton("Update",
//                DialogInterface.OnClickListener { dialogInterface, i ->
//                    //Dismiss
//                })








        buttonLogIn!!.setOnClickListener {

//            ......
            ps()


        }

    }

    private fun ps() {
        //         Get data from the user
        val email =findViewById<EditText>(R.id.inputEmail)
        val password =findViewById<EditText>(R.id.inputPassword)

        val input_Email = email.text.toString()
        val input_Password = password.text.toString()

        if (input_Email.isEmpty() || input_Password.isEmpty()){

            Toast.makeText(this,"Kindly Fill All Fields!",Toast.LENGTH_SHORT).show()

            return

        }

        auth.signInWithEmailAndPassword(input_Email, input_Password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, Navigate to the MainActivity
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Login Successful",
                        Toast.LENGTH_SHORT).show()

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed. Try Again !",
                        Toast.LENGTH_SHORT).show()

                }
            }

            .addOnFailureListener {
                Toast.makeText(this,"Error occurred ${it.localizedMessage}",Toast.LENGTH_SHORT).show()
            }

    }


}