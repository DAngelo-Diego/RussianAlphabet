package com.study.russian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.study.russian.databinding.ActivityAuthBinding
import com.study.russian.databinding.ActivityHomeBinding
import com.study.russian.util.Constants.EMAIL

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Russia)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Setup
        val bundle = intent.extras
        val email = bundle?.getString(EMAIL)

            setup(email = email ?: "")

    }

    private fun setup(email: String) {

        title = "home"

        binding.tvEmail.text = email

        binding.btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
        }

    }

}