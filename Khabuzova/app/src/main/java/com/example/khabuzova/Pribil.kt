package com.example.khabuzova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.khabuzova.databinding.ActivityPribilBinding

class Pribil : AppCompatActivity() {
    private lateinit var binding: ActivityPribilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPribilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.raschetpribil.setOnClickListener{
            binding.result.setText("")
            if (binding.leadsEditText.text.isNotEmpty() && binding.ratioEditText.text.isNotEmpty() && binding.chekEditText.text.isNotEmpty() && binding.saleEditText.text.isNotEmpty() && binding.marzhaEditText.text.isNotEmpty()){
                var leads = binding.leadsEditText.text.toString().toDouble()
                var ratio = binding.ratioEditText.text.toString().toDouble()
                var chek = binding.chekEditText.text.toString().toDouble()
                var sale = binding.saleEditText.text.toString().toDouble()
                var marzha = binding.marzhaEditText.text.toString().toDouble()
                if (leads%1!=0.0 || sale%1!=0.0){
                    if (leads%1!=0.0) {
                        Toast.makeText(this, "Лиды - целочисленное число", Toast.LENGTH_LONG).show()
                    } else{
                        Toast.makeText(this, "Повторные продажи - целочисленное число", Toast.LENGTH_LONG).show()
                    }
                }else {
                    var result = leads*ratio*chek*sale*marzha/10000
                    binding.result.setText("Прибль: $result")
                }
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            }
        }
        binding.delete.setOnClickListener{
            binding.leadsEditText.setText("")
            binding.ratioEditText.setText("")
            binding.chekEditText.setText("")
            binding.saleEditText.setText("")
            binding.marzhaEditText.setText("")
            binding.result.setText("")
        }
        binding.back.setOnClickListener{
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