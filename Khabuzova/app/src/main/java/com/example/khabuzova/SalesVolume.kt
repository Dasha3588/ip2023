package com.example.khabuzova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.khabuzova.databinding.ActivitySalesVolumeBinding

class SalesVolume : AppCompatActivity() {
    private lateinit var binding: ActivitySalesVolumeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalesVolumeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.raschet2.setOnClickListener {
            binding.result2.setText("")
            if (binding.editTextClients.text.isNotEmpty() && binding.editTextIncome.text.isNotEmpty()) {
                var clients = binding.editTextClients.text.toString().toDouble()
                var income = binding.editTextIncome.text.toString().toDouble()
                if (clients % 1 != 0.0) {
                    Toast.makeText(this, "Количество клиентов - целочисленное число", Toast.LENGTH_LONG).show()
                } else {
                    var result = clients * income
                    binding.result2.setText("Объём продаж: $result")
                }
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
        }
    }
        binding.delete2.setOnClickListener{
            binding.editTextClients.setText("")
            binding.editTextIncome.setText("")
            binding.result2.setText("")
        }
        binding.back2.setOnClickListener{
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