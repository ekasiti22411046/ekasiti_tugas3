package com.example.tugas_eka3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas_eka3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btlogin.setOnClickListener {
            val intentHome = Intent(this, home::class.java)
            startActivity(intentHome)
        }

        binding.tvdaftar.setOnClickListener {
            val intentHome = Intent(this, register::class.java)
            startActivity(intentHome)
        }

        binding.tvlppass.setOnClickListener {
            val intentHome = Intent(this, forgot_password::class.java)
            startActivity(intentHome)
        }


    }
}