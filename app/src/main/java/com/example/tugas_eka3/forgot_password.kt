package com.example.tugas_eka3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas_eka3.databinding.ActivityForgotPasswordBinding
import com.example.tugas_eka3.databinding.ActivityMainBinding

class forgot_password : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvmasuk.setOnClickListener {
            val intentHome = Intent(this, MainActivity::class.java)
            startActivity(intentHome)
        }

        val btnForgotPassword = findViewById<Button>(R.id.btrstpass)
        btnForgotPassword.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("admin@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Permintaan Reset Password")
                putExtra(Intent.EXTRA_TEXT, "Halo Admin,\n\nSaya ingin mereset password akun saya.\n\nTerima kasih.")
            }

            try {
                startActivity(Intent.createChooser(intent, "Pilih aplikasi email"))
            } catch (ex: android.content.ActivityNotFoundException) {
                Toast.makeText(this, "Tidak ada aplikasi email terinstal.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}