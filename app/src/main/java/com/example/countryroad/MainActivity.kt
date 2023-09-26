package com.example.countryroad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast

import com.example.countryroad.International
import com.example.countryroad.R
import com.example.countryroad.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var provinces: Array<String>
    private lateinit var Countries: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnInternational.setOnClickListener{
                val intent = Intent(this@MainActivity, International::class.java)
                startActivity(intent)
            }

        }
    }
}