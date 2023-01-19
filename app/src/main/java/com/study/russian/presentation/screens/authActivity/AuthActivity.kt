package com.study.russian.presentation.screens.authActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.study.russian.HomeActivity
import com.study.russian.R
import com.study.russian.databinding.ActivityAuthBinding
import com.study.russian.util.Constants.EMAIL

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Splash
        setTheme(R.style.Theme_Russia)
        //ViewBinding
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // Setup
        setup()
    }

    private fun setup(){

        title = "Authentication"


        binding.btnSignUp.setOnClickListener {
            val etEmail = binding.etEmail.text
            val etPassword = binding.etPassword.text
            if (etEmail.isNotEmpty() && etPassword.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(etEmail.toString(), etPassword.toString())
                    .addOnCompleteListener {
                        try {

                            val msjError = "com.google.firebase.auth.FirebaseAuthUserCollisionException: The email address is already in use by another account"

                            if (it.isSuccessful) {
                                navigateToHome(it.result.user?.email ?: "")
                            } else if (it.exception?.toString()
                                    ?.contains(msjError) == true
                            ) {
                                showEmailUsedAlert()
                            } else {
                                showFailedRegisterAlert()
                            }
                        } catch (e: FirebaseAuthException) {
                            Toast.makeText(this, "Something woes wrong", Toast.LENGTH_LONG).show()
                        }
                    }

            }
        }

        binding.btnLogin .setOnClickListener {
            val etEmail = binding.etEmail.text
            val etPassword = binding.etPassword.text
            if (etEmail.isNotEmpty() && etPassword.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(etEmail.toString(), etPassword.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            navigateToHome(it.result.user?.email ?: "")
                        } else {
                            showWrongPasswordAlert()
                        }
                    }

            }
        }
    }

    private fun showFailedRegisterAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error with the registration")
        builder.setMessage("Has been an error with user registration or the password is too short")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showWrongPasswordAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Wrong Password")
        builder.setMessage("Has been an error with the password!")
        builder.setPositiveButton("TRY AGAIN", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showEmailUsedAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Email is already in use")
        builder.setMessage("Another user already took the email!")
        builder.setPositiveButton("Go back", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun navigateToHome(email: String){
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra(EMAIL, email)
        }
        startActivity(homeIntent)
    }


}