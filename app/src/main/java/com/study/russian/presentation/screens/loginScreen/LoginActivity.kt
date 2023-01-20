package com.study.russian.presentation.screens.loginScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.russian.R
import com.study.russian.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

     private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_Russia)
        val view = binding.root
        setContentView(view)

    }
}