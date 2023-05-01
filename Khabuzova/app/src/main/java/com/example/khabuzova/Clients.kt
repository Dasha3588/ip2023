package com.example.khabuzova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.khabuzova.databinding.ActivityClientsBinding

class Clients : AppCompatActivity() {
    private lateinit var binding: ActivityClientsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.raschetclients3.setOnClickListener {
            binding.result3.setText("")
            if (binding.editTextLeads.text.isNotEmpty() && binding.editTextRatio.text.isNotEmpty()) {
                var leads = binding.editTextLeads.text.toString().toDouble()
                var ratio = binding.editTextRatio.text.toString().toDouble()
                if (leads % 1 != 0.0) {
                    Toast.makeText(this, "Лиды - целочисленное число", Toast.LENGTH_LONG).show()
                } else {
                    var result = leads * ratio
                    binding.result3.setText("Количество клиентов: $result")
                }
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            }
        }
        binding.delete3.setOnClickListener{
            binding.editTextLeads.setText("")
            binding.editTextRatio.setText("")
            binding.result3.setText("")
        }
        binding.back3.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}