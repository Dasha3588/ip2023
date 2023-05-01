package com.example.khabuzova

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.khabuzova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cardViewmoney.setOnClickListener {
            val intent = Intent(this, Pribil::class.java)
            startActivity(intent)
            finish()
        }
        binding.cardViewteam.setOnClickListener {
            val intent = Intent(this, Clients::class.java)
            startActivity(intent)
            finish()
        }
        binding.cardViewsv.setOnClickListener {
            val intent = Intent(this, SalesVolume::class.java)
            startActivity(intent)
            finish()
        }
        binding.cardViewexit.setOnClickListener {
            finishAndRemoveTask()
        }
    }
}