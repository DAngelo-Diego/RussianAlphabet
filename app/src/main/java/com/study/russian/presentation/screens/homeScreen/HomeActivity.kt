package com.study.russian.presentation.screens.homeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.russian.R
import com.study.russian.databinding.FragmentLoginBinding
import com.study.russian.presentation.screens.signupScreen.SignUpFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Russia)
        setContentView(R.layout.activity_home)
    }
}