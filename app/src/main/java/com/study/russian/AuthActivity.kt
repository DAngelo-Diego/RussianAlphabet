package com.study.russian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
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
                        if (it.isSuccessful) {
                            navigateToHome(it.result.user?.email ?: "")
                        } else {
                            showAlert()
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

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Has been an error with user auth")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showWrongPasswordAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Has been an error with the password")
        builder.setPositiveButton("Accept", null)
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