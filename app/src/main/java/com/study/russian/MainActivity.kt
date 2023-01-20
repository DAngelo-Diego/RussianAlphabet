package com.study.russian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.russian.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

     private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_Russia)
        val view = binding.root
        setContentView(view)

    }
}