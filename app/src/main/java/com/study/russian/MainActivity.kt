package com.study.russian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Russia)
        setContentView(R.layout.activity_main)
    }
}